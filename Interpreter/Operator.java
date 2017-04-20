public class Operator{
   int val1;
   int val2;
   String op;
   
   public Operator(int val1, String op, int val2){
      this.val1 = val1;
      this.val2 = val2;
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
