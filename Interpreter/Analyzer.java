import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Analyzer{
   public List<Token> myTokens = new ArrayList<Token>();
   private String tokenType;
   
   public Analyzer(String fileName) throws FileNotFoundException{
      Scanner scan = new Scanner(new File(fileName));
      int lineNumber = 1;
      
      while(scan.hasNextLine()){  
         lineAnalyzer(scan.nextLine(), lineNumber);
         lineNumber++;
      }
   }    
     
   public String tokenAssigner(String lexeme){
   
      if(lexeme.equals("-"))
         tokenType = "sub_operator";
      else if(lexeme.equals("+"))
         tokenType = "add_operator";
      else if(lexeme.equals("/"))
         tokenType = "div_operator";
      else if(lexeme.equals("*"))
         tokenType = "mul_operator";
     
            //Relational operators
      if(lexeme.equals(">"))
         tokenType = "gt_operator";
      else if(lexeme.equals(">=") || lexeme.equals("=>"))
         tokenType = "ge_operator";
      else if(lexeme.equals("<"))
         tokenType = "lt_operator";
      else if(lexeme.equals("<=") || lexeme.equals("=<"))
         tokenType = "le_operator";
      else if(lexeme.equals("(") || lexeme.equals("=<"))
         tokenType = "lparen_operator";
      else if(lexeme.equals(")") || lexeme.equals("=<"))
         tokenType = "rparen_operator";
         
      if(lexeme.equals("="))
         tokenType = "assignment_operator";
      else if(lexeme.equals("=="))
         tokenType = "eq_operator";
      else if(lexeme.equals("~="))
         tokenType = "ne_operator";
         
            //Value/statement type
      if(isNumeric(lexeme))
         tokenType = "digit";
      else if((lexeme.length() == 1) && Character.isLetter(lexeme.charAt(0)))
         tokenType = "ID";
      else if((lexeme.length() > 1 && Character.isLetter(lexeme.charAt(0)))){
         if(lexeme.equals("if"))
            tokenType = "if_stmt";
         else if(lexeme.equals("while"))
            tokenType = "while_stmt";
         else if(lexeme.equals("do"))
            tokenType = "do_stmt";
         else if(lexeme.equals("else"))
            tokenType = "else_stmt";
         else if(lexeme.equals("then"))
            tokenType = "then_stmt";
         else if(lexeme.equals("end"))
            tokenType = "end_stmt";
         else if(lexeme.equals("print"))
            tokenType = "print_stmt";
         else if(lexeme.equals("repeat"))
            tokenType = "repeat_stmt";
         else if(lexeme.equals("until"))
            tokenType = "until_stmt";
      }
      return tokenType;
   }
   
   
   public List<Token> getMyTokenList(){
      return myTokens;
   }
   
   public Token removeNextToken(){
      return myTokens.remove(0);
   }
   
   public Token getNextToken(){
      return myTokens.get(0);
   }
   
   
  //Checks if value is a number
   public static boolean isNumeric(String str){  
      try{  
         int d = Integer.parseInt(str);  
      }  
      catch(NumberFormatException nfe){  
         return false;  
      }  
      return true;  
   }
    
   
   public void lineAnalyzer(String line, int lineNumber){
      Scanner scan = new Scanner(line);
      while(scan.hasNext()){
         String lexeme = scan.next();
         String tokenType = tokenAssigner(lexeme);
         Token curToken = new Token(lexeme, tokenType, lineNumber);
         
         myTokens.add(curToken);
      }
   }

}