public class WhileStatement extends Statement{
   private BooleanExpression o1;
   private Block b1;
   public WhileStatement(BooleanExpression o1, Block b1){
      this.o1 = o1;
      this.b1 = b1;
   }
   
   public void run(){
      while(o1.run())
         b1.run();
   }
}