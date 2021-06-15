
public class Laptop{
   private float screenSize;
   private String maker;
   private int model;
   private float speed;
   private int ram;
   private int hd;
   private int price;
   public Laptop(){
      setMaker("0");
      setModel(0);
      setSpeed(0);
      setRam(0);
      setHd(0);
      setScreenSize(0);
      setPrice(0);
   }
   public Laptop(String make, int m, float s, int r, int h, float screen, int p) {
      setMaker(make);
      setModel(m);
      setSpeed(s);
      setRam(r);
      setHd(h);
      setScreenSize(screen);
      setPrice(p);
   }
   public String getMaker() {
      return maker;
   }
   public int getModel()  {
      return model;
   }
   public float getSpeed() {
      return speed;
   }
   public int getRam(){
      return ram;
   }
   public int getHd(){
      return hd;
   }
   public int getPrice(){
      return price;
   }
   public void setPrice(int p){
      price = p;
   }
   public void setModel(int m) {
      model = m;
   }
   public void setSpeed(float s) {
      speed = s;
   }
   public void setRam(int r) {
      ram = r;
   }
   public void setHd(int h){
      hd = h;
   }
   public void setMaker(String make){
      this.maker = make;
   }
   public float getScreenSize(){
      return screenSize;
   }
   public void setScreenSize(float screen){
      screenSize = screen;
   }
      
}