//This code is the skeletal structure of our program and only calls the other classes when functions are necessary
import java.util.ArrayList;
public class computersController {
   public static void main(String[] args) {
      computersView view = new computersView();
      computersModel mod = new computersModel();
      //creates lists for our queries of items in inventory
      ArrayList<Laptop> resultsLaptop = new ArrayList<Laptop>();
      ArrayList<Desktop> resultsDesktop = new ArrayList<Desktop>();
      ArrayList<Printer> resultsPrinter = new ArrayList<Printer>();
      //sets items for purchase
      Desktop purDesktop = new Desktop();
      Laptop purLaptop = new Laptop();
      Printer purPrinter = new Printer();
      //creates a cart
      Cart cart = new Cart();
      //sets up item for userInput
      String item = "";
      int itemNo = 0;
      item = view.getUserInputInitial();
      //if item = 0, we stop as per our request in their input
      while(!item.equals("0")){
         //clears current items seen
         resultsDesktop.clear();
         resultsLaptop.clear();
         resultsPrinter.clear();
         //desktop branch
         if(item.equals("desktop")){
            int max;
            //requests max price
            max = view.getPrice();
            //returns desktops with max price
            resultsDesktop = mod.queryDesktops(max);
            //displays Desktops
            view.displayDesktops(resultsDesktop);
         }
         else {
            //laptop branch
            if(item.equals("laptop")){
               //asks for range of screen size
               String range = view.getRange();
               //returns laptops in screen range
               resultsLaptop = mod.queryLaptops(range);
               //displays laptops
               view.displayLaptops(resultsLaptop);
            }
            
            else {
               if(item.equals("printer")){
                  //gets type of printer wanted
                  String type = view.getType();
                  //returns printers of that type
                  resultsPrinter = mod.queryPrinters(type);
                  //displays results
                  view.displayPrinters(resultsPrinter);
               }
            }
         }
         //gets item they want to purchase
         itemNo = view.askForPurchase();
         if(itemNo <= resultsDesktop.size()){
            purDesktop = resultsDesktop.get(itemNo-1);
            cart.addToCart(purDesktop.getModel(), purDesktop.getPrice());
         }
         if(itemNo <= resultsLaptop.size()){
            purLaptop = resultsLaptop.get(itemNo-1);
            cart.addToCart(purLaptop.getModel(), purLaptop.getPrice());
         }
         if(itemNo <= resultsPrinter.size()){
            purPrinter = resultsPrinter.get(itemNo-1);
            cart.addToCart(purPrinter.getModel(), purPrinter.getPrice());
         }
         //asks if they are done.
         String done = view.askForCompletion();
         //finishes
         if(done.equals("yes")){
            //displays order
            view.displayOrder(cart);
            //inventory fixed
            mod.addOrder(cart);
            //reset cart
            cart.resetCart();
            //thank customer
            view.thanks();
         }
         item = view.getUserInputInitial();
      
      }
      
   
   }
}
