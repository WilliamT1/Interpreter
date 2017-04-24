public class IfStatement extends Statement{
   BooleanExpression o1;
   Block b1;
   Block b2;
   
   public IfStatement(BooleanExpression o1, Block b1, Block b2){
      this.o1 = o1;
      this.b1 = b1;
      this.b2 = b2;
   }
   public void run(){
      if(o1.run())
         b1.run();
      else
         b2.run();
   }
}