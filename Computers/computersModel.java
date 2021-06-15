//This code will handle the back end of our program which will be used in the Controller
//importing necessary Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class computersModel{
   private Connection conn;
   public computersModel() {
      //establishing connection
      try {
         conn = DriverManager.getConnection("jdbc:sqlserver://{database_name_and_port_here};database=ComputerStore;user= {your_username_here;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
      } catch (SQLException e) {
         System.err.println(e.getMessage());
      }
   }
   public ArrayList<Desktop> queryDesktops(int max) {   
      //creates list to store desktops
      ArrayList<Desktop> desktops = new ArrayList<Desktop>();
      try {
         //creates a statement to query through desktops
         String query = "select b.maker, a.model, a.speed, a.ram, a.hd, b.price  from PC a NATURAL JOIN Product b where b.prodType = 'PC' and price < ? and inventory > 0";
         PreparedStatement statement = conn.prepareStatement(query);
         statement.setInt(1, max);
         //gets resultSet
         ResultSet rs = statement.executeQuery();
         //gets each individual result stored into our array list
         while (rs.next()){
            desktops.add(new Desktop(rs.getString("maker"), rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getInt("price")));
         }
      }
      catch(SQLException e) {
         System.err.println(e.getMessage());
      }
      //returns our arraylist
      return desktops;
   }
   public ArrayList<Laptop> queryLaptops(String size) {   
      //creates arrayList of laptops
      ArrayList<Laptop> laptops = new ArrayList<Laptop>();
      try {
         //creating statement to query the database
         String query = "select b.maker, a.model, a.speed, a.ram, a.hd, a.screen, b.price  from Laptop a NATURAL JOIN Product b where b.prodType = 'laptop' and screen <= ? and screen >= ? and inventory > 0";
         PreparedStatement statement = conn.prepareStatement(query);
         //develops the query based on laptop screen size (stored as float)
         statement.setFloat(1, Float.parseFloat(size.substring(0, size.indexOf(','))));
         statement.setFloat(2, Float.parseFloat(size.substring(size.indexOf(',') + 1)));
         //producing result set
         ResultSet rs = statement.executeQuery();
         //iterating through result set
         while (rs.next()){
            laptops.add(new Laptop(rs.getString("maker"), rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getFloat("screen"), rs.getInt("price")));
         }
      }
      catch(SQLException e) {
         System.err.println(e.getMessage());
      }
      //return the ArrayList
      return laptops;
   }
   public ArrayList<Printer> queryPrinters(String type) {   
      //creating ArrayList
      ArrayList<Printer> printers = new ArrayList<Printer>();
      int color;
      //database stores color printers as 1 and black and white printers as 0, trusting intelligent input here.
      if(type.equals("black-and-white"))
         color = 0;
      else
         color = 1;
      try {
         //creates the query
         String query = "select b.maker, a.model, a.printerType, b.price  from Printer a NATURAL JOIN Product b where color = ? and inventory > 0";
         PreparedStatement statement = conn.prepareStatement(query);
         //setting our int ? to what our desired printer is
         statement.setInt(1, color);
         ResultSet rs = statement.executeQuery();
         //iterates through result set
         while (rs.next()){
            printers.add(new Printer(rs.getString("maker"), rs.getInt("model"), rs.getString("printerType"), rs.getInt("price")));
         }
      }
      catch(SQLException e) {
         System.err.println(e.getMessage());
      }
      //returns our ArrayList
      return printers;
   }
   public void addOrder(Cart cart){
      int newOrder = 0;
      try {
         //returns the count of current orderNumbers
         String query = "select COUNT(DISTINCT orderNumber) from Orders";
         PreparedStatement statement = conn.prepareStatement(query);
         //gives our result set
         ResultSet rs = statement.executeQuery();
         //returns number of current orderNumbers
         newOrder = rs.getInt("COUNT(DISTINCT orderNumber)") + 1;
      } catch(SQLException e) {
         System.err.println(e.getMessage());
      }
      //gets number of items in the cart
      System.out.println(cart.getSize());
      while(cart.getSize() > 0){
         try{
            //inserts order into our database
            String query1 = "insert into Orders values (?, ?, ?, \"Ryan\")";
            PreparedStatement statement1 = conn.prepareStatement(query1);
            statement1.setInt(1, newOrder);
            statement1.setInt(2, cart.lastItem());
            statement1.setInt(3, cart.lastPrice());
            //changes the number of inventory available.
            String query2 = "update Product set inventory = inventory - 1 where model = ?";
            PreparedStatement statement2 = conn.prepareStatement(query2);
            statement2.setInt(1, cart.lastItem());
            statement1.executeUpdate();
            statement2.executeUpdate();
            //drops an item out of the cart (we've applied the changes necessary to do so.)
            cart.dropSize();
         } catch(SQLException e) {
            System.err.println(e.getMessage());
         }
         //gives the current size of cart.
         System.out.println(cart.getSize());
      }
      
   }
}