import java.util.List;
import java.io.FileNotFoundException;
public class Interpreter{
   public static void main(String[] args) throws FileNotFoundException{
      Parser myParser = new Parser("example.txt");
      
      List<Token> myTokens = myParser.getMyTokenList();
      Token curToken = myTokens.get(0);
      System.out.print(curToken.getLexeme() + ", " + curToken.getTokenType());
   
      
   }
}