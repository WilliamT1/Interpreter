import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Parser{
   public Id id = new Id();
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
         else if(myToken.getTokenType().equals("ID"))
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
   
   public void getOperand(Token myToken){
      if(myToken.getTokenType().equals("ID") && getNextToken().getTokenType().contains("assignment")){
         myToken.setLexeme(myToken.getLexeme().toLowerCase());
         char c = myToken.getLexeme().charAt(0);
         id.setId(c);
         removeNextToken();
         id.store(Integer.parseInt(removeNextToken().getLexeme()));
      }
      else if(myToken.getTokenType().equals("ID") && getNextToken().getTokenType().contains("_operator")){
         ArithmeticOperator op = new ArithmeticOperator(id, removeNextToken().getTokenType(), Integer.valueOf(removeNextToken().getLexeme()));
         System.out.print(op.evaluate());
      }
      else{
         ArithmeticOperator op = new ArithmeticOperator(Integer.valueOf(myToken.getLexeme()), removeNextToken().getTokenType(), Integer.valueOf(removeNextToken().getLexeme()));
         System.out.print(op.evaluate());
      }
   }
   
   public Token getNextToken(){
      return lexicalAnalyzer.getNextToken();
   }
   
   public int getLastLine(){
      Token lastItem =  myTokens.get(myTokens.size()-1);
      int lastLine = lastItem.getLineNumber();
      return lastLine;
   }
   
   
}