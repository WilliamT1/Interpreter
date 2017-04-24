public class BooleanExpression{
   ArithmeticExpression e1;
   ArithmeticExpression e2;
   String op;
   public BooleanExpression(ArithmeticExpression e1, String op, ArithmeticExpression e2){
      this.e1= e1;
      this.e2 = e2;
      this.op = op;
   }
   
   public boolean run(){
      boolean finalVal = false;
      switch(op){
         case "gt_operator":
            finalVal = e1.run() > e2.run();
            break;
         case "ge_operator":
            finalVal = e1.run() >= e2.run();
            break;
         case "lt_operator":
            finalVal = e1.run() < e2.run();
            break;
         case "le_operator":
            finalVal = e1.run() <= e2.run();
         case "eq_operator":
            finalVal = e1.run() == e2.run();
         case "ne_operator": 
            finalVal = e1.run() != e2.run();
            break;
      }
      return finalVal;
   };
}