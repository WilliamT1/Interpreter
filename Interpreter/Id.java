public class Id extends ArithmeticExpression{
   private char id;
   private int[] valueOfId;
   
   public Id(char id, int[] valueOfId){
      this.id = id;
      this.valueOfId = valueOfId;
   }
   
   public char getId(){
      return id;
   }
   
   public void store(int value){
      valueOfId[id] = value;
   }

   public int run(){
      return valueOfId[id];
   }
}