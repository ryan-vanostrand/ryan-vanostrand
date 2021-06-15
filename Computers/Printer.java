public class Printer {
   private String maker;
   private int model;
   private String type;
   private int price;
   public Printer(){
      setMaker("0");
      setModel(0);
      setType("0");
      setPrice(0);
   }
   public Printer(String make, int m, String t, int p){
      maker = make;
      model = m;
      type = t;
      price = p;
   }
   public String getMaker() {
      return maker;
   }
   public int getModel()  {
      return model;
   }
   public void setPrice(int p){
      price = p;
   }
   public int getPrice(){
      return price;
   }
   public void setMaker(String make){
      this.maker = make;
   }
   public String getType(){
      return type;
   }
   public void setType(String t){
      type = t;
   }
   public void setModel(int m){
      model = m;
   }
    
}