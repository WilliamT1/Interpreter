public class ArithmeticOperator extends ArithmeticExpression{
   int val1;
   int val2;
   String op;
   Id id = new Id();
   
   public ArithmeticOperator(int val1, String op, int val2){
      this.val1 = val1;
      this.val2 = val2;
      this.op = op;
   }
   
   public ArithmeticOperator(Id id, String op, int val1){
      this.val1 = val1;
      this.val2 = id.getValue();
      this.op = op;
   }
   
   public int evaluate(){
      int finalVal = 0;
      switch(op){
         case "add_operator":
            finalVal = val1 + val2;
            break;
         case "sub_operator":
            finalVal = val1 - val2;
            break;
         case "mul_operator":
            finalVal = val1 * val2;
            break;
         case "div_operator":
            finalVal = val1 / val2;
            break;
      }
      return finalVal;
   };
}
