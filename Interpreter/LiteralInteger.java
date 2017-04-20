public class LiteralInteger extends ArithmeticExpression{
   private int litInt;
   public LiteralInteger(int litInt){
      this.litInt = litInt;
   }
      
   public int getLitInt(){
      return litInt;
   }
}