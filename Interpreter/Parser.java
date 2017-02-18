import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Parser{
   public List<Token> myTokens = new ArrayList<Token>();
   private String tokenType;
   
   public Parser(String fileName) throws FileNotFoundException{
      Scanner scan = new Scanner(new File(fileName));
      
      while(scan.hasNext()){  
         String lexeme = scan.next();
         String tokenType = tokenAssigner(lexeme);
         Token curToken = new Token(lexeme, tokenType);
         
         myTokens.add(curToken);
      }
   }    
     
   public String tokenAssigner(String lexeme){
      if(lexeme.equals("-"))
         tokenType = "Minus";
      else if(lexeme.equals("+"))
         tokenType = "Plus";
      else if(lexeme.equals("/"))
         tokenType = "Divide";
      else if(lexeme.equals("*"))
         tokenType = "Multiply";
     return tokenType;
   }
   
   
   public List<Token> getMyTokenList(){
      return myTokens;
   }
}