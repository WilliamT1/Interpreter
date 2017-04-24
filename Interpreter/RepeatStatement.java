public class RepeatStatement extends Statement{
   Block b1;
   BooleanExpression e1;
   public RepeatStatement(Block b1, BooleanExpression e1){
      this.e1 = e1;
      this.b1 = b1;
   }
   
   void run(){
      do
         b1.run();
      while(e1.evaluate());
   }
}