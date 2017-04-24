public class ArithmeticOperator extends ArithmeticExpression{
   ArithmeticExpression e1;
   ArithmeticExpression e2;
   String op;
   
   public ArithmeticOperator(ArithmeticExpression e1, String op, ArithmeticExpression e2){
      this.e1 = e1;
      this.e2 = e2;
      this.op = op;
   }
      
   public int run(){
      int finalVal = 0;
      switch(op){
         case "add_operator":
            finalVal = e1.run() + e2.run();
            break;
         case "sub_operator":
            finalVal = e1.run() - e2.run();
            break;
         case "mul_operator":
            finalVal = e1.run() * e2.run();
            break;
         case "div_operator":
            finalVal = e1.run() / e2.run();
            break;
      }
      return finalVal;
   };
}
