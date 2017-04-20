import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Parser{

   public List<Token> myTokens;
   private Analyzer lexicalAnalyzer;
   
   public Parser(String fileName) throws FileNotFoundException{
      lexicalAnalyzer = new Analyzer(fileName);
   }
   
      
   public void parse(){
      Token myToken = removeNextToken();
      if(isValidStart(myToken)){
         if(myToken.getTokenType().equals("digit"))
            getOperand(myToken);
      }
   }
   
   public boolean isValidStart(Token myToken){
      return myToken.getTokenType().equals("if_stmt") ||
         myToken.getTokenType().equals("while_stmt") || 
         myToken.getTokenType().equals("print_stmt") ||
         myToken.getTokenType().equals("ID") ||
         myToken.getTokenType().equals("digit") ||
         myToken.getTokenType().equals("repeat_stmt");
   }
   
   public Token removeNextToken(){
      return lexicalAnalyzer.removeNextToken();
   }
   
   public int getOperand(Token myToken){
      Operator op = new Operator(Integer.valueOf(myToken.getLexeme()), removeNextToken().getTokenType(), Integer.valueOf(removeNextToken().getLexeme()));
      System.out.print(op.evaluate());
      return op.evaluate();
   }
   
   public Token getNextToken(){
      return lexicalAnalyzer.getNextToken();
   }
   
   
}