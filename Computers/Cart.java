public class Cart {
   private int[] modelNos = new int[50];
   private int[] prices = new int[50];
   private int size;
   private int totalPrice;
   public Cart(){
      for(int i = 0; i < 50; i++){
         modelNos[i] = 0;
         prices[i] = 0;
      }
      size = 0;
   }
   public void addToCart(int modelNo, int price){
      modelNos[size] = modelNo;
      prices[size] = price;
      size++;
      totalPrice = totalPrice + price;
   }
   public void dropSize(){
      size--;
   }
   public void resetCart(){
      for(int i = 0; i < 50; i++){
         modelNos[i] = 0;
         prices[i] = 0;
      }
      size = 0;
      totalPrice = 0;
   }
   public int lastItem(){
      return modelNos[size-1];
   }
   public int lastPrice(){
      return prices[size-1];
   }
   public int getSize(){
      return size;
   }
   public int getTotal(){
      return totalPrice;
   }
}