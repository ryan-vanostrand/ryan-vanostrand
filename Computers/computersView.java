/* This source code will set up interactions with our end user that will be implemented in the Controller.
 */
//importing proper Libraries
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
//creating a view for enduser
public class computersView {
   Scanner kb;
   //initializing keyboard as input
   public computersView() {
      kb = new Scanner(System.in);
   }
   //gets user input, puts it to lowercase and trims it.
   public String getUserInputInitial(){
      System.out.println("Would you like a \"desktop\", \"laptop\" or \"printer\" today? If you would like to clear your cart and exit, enter 0");
      String item = kb.nextLine();
      item = item.toLowerCase();
      item = item.trim();
      return item;
   }
   //gets max price for computer and clears the return carriage from the console returning price
   public int getPrice(){
      System.out.println("What is the highest amount you would pay for a Desktop (in dollars)?");
      int price = kb.nextInt();
      kb.nextLine();
      return price;
   }
   //gets a range of screen size, used for laptops.
   public String getRange(){
      System.out.println("What is the largest screen size you would want (in inches)?");
      String size = "" + kb.next();
      kb.nextLine();
      System.out.println("What is the smallest screen size you would want (in inches)?");
      size = size + "," + kb.next();
      kb.nextLine();
      System.out.println("High: " + size.substring(0, size.indexOf(',')));
      System.out.println("Low: " + size.substring(size.indexOf(',') + 1));
      return size;
   }
   //gets whether they'd like a color or black and white printer.
   public String getType(){
      System.out.println("Would you want a \"color\" or \"black-and-white\" printer?");
      String type = kb.next();
      kb.nextLine();
      return type;
   }
   //displays the current available desktops
   public void displayDesktops(ArrayList<Desktop> desktops) {
      int numDesktops = desktops.size();
      System.out.println("These are the available desktops.");
      for(int i = 1; i <= numDesktops; i++){
         Desktop currDesktop = desktops.get(i-1);
         System.out.println("Desktop " + i + ": " + currDesktop.getMaker() + ", " + currDesktop.getModel() + ", " + currDesktop.getSpeed() + ", " + currDesktop.getRam() + ", " + currDesktop.getHd() + ", " + currDesktop.getPrice() + ".");
      }
   }
   //displays the current available laptops
   public void displayLaptops(ArrayList<Laptop> laptops) {
      int numLaptops = laptops.size();
      for(int i = 1; i <= numLaptops; i++){
         Laptop currLaptop = laptops.get(i-1);
         System.out.println("Laptop " + i + ": " + currLaptop.getMaker() + ", " + currLaptop.getModel() + ", " + currLaptop.getSpeed() + ", " + currLaptop.getRam() + ", " + currLaptop.getHd() + ", " + currLaptop.getScreenSize() + ", " + currLaptop.getPrice() + ".");
      }
      System.out.println("Those are the available laptops.");
   }
   //displays the current available printers
   public void displayPrinters(ArrayList<Printer> printers) {
      int numPrinters = printers.size();
      for(int i = 1; i <= numPrinters; i++){
         Printer currPrinter = printers.get(i-1);
         System.out.println("Printer " + i + ": " + currPrinter.getMaker() + ", " + currPrinter.getModel() + ", " + currPrinter.getType() +", " + currPrinter.getPrice() + ".");
      }
      System.out.println("Those are the available printers.");
   }
   //does what it says, returns the product they'd like
   public int askForPurchase() {
      int purchaseNumber;
      System.out.println("Which product would you like to purchase? If you would not like to add an item to your cart at this time, enter 0.");
      purchaseNumber = kb.nextInt();
      kb.nextLine();
      return purchaseNumber;
   }
   //asks if they're done.
   public String askForCompletion(){
      System.out.println("Would you like to procede to checkout, \"yes\" or \"no\"?");
      String stringy = kb.next();
      kb.nextLine();
      return stringy;
   }
   //displays their current order
   public void displayOrder(Cart cart){
      System.out.println("You've ordered " + cart.getSize() + "items at $" + cart.getTotal());
   }
   //thanks them
   public void thanks(){
      System.out.println("Thanks for your business. Hit any key followed by enter to continue.");
      String anyKey = kb.next();
      kb.nextLine();
     
   }
      
}