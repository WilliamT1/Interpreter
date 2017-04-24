public class PrintStatement extends Statement{
   ArithmeticExpression e1;
   public PrintStatement(ArithmeticExpression e1){
      this.e1 = e1;
   }
   public void run(){
      System.out.println(e1.run());
   }
}