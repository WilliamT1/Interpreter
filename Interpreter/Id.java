public class Id extends ArithmeticExpression{
   private char id;
   private int[] valueOfId = new int['z'+1];
   
   public Id(){
   }
   
   public Id(char id){
      this.id = id;
   }
   
   public char getId(){
      return id;
   }
   
   public void setId(char c){
      id = c;
   }
   
   public void store(int value){
      valueOfId[id] = value;
   }
   
   public int getValue(){
      return valueOfId[id];
   }
}