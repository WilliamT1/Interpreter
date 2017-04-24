public class AssignmentStatement extends Statement{
   private ArithmeticExpression e1;
   private Id id;
   
   
   public AssignmentStatement(ArithmeticExpression e1, Id id){
      this.e1 = e1;
      this.id = id;
   }
      
   public void run(){
      id.store(e1.run());
   }
}