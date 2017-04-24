import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Parser{
   public List<Token> myTokens;
   private Analyzer lexicalAnalyzer;
   private int[] valueOfId = new int['z'+1];
   
   public Parser(String fileName) throws FileNotFoundException{
      lexicalAnalyzer = new Analyzer(fileName);
   }
   
      
   public Program parse(){
      Block b1 = newBlock();
      Program p1 = new Program(b1);
      return p1;
   }
   
   public Block newBlock(){
      Block b = new Block();
      Token myToken = getNextToken();
      while(isValidStart(myToken)){
         Statement s = newStatement();
         b.addStatement(s);
         if(getNextToken() == null || getNextToken().getTokenType().equals("eof"))
            break;
         else
            myToken = getNextToken();
      }
      return b;
   }
   
   public Statement newStatement(){
      Statement s = null;
      Token myToken = getNextToken();
      if(myToken.getTokenType().equals("if_stmt"))
         s = newIfStatement();
      else if(myToken.getTokenType().equals("while_stmt"))
         s = newWhileStatement();
      else if(myToken.getTokenType().equals("print_stmt"))
         s = newPrintStatement();
      else if(myToken.getTokenType().equals("repeat_stmt"))
         s = newRepeatStatement();
      else if(myToken.getTokenType().equals("ID"))
         s = newAssignmentStatement();
      return s;
   }
   
   public IfStatement newIfStatement(){
      Block b1 = null;
      Block b2 = null;
      BooleanExpression expression = null;
      Token myToken = removeNextToken();
      if(myToken.getTokenType().equals("if_stmt"))
         expression = newBooleanExpression();
      myToken = removeNextToken();
      if(myToken.getTokenType().equals("then_stmt"))
         b1 = newBlock();
      myToken = removeNextToken();
      if(myToken.getTokenType().equals("else_stmt"))
         b2 = newBlock();
      IfStatement tempIf = new IfStatement(expression, b1, b2);
      return tempIf;
   }
   
   public WhileStatement newWhileStatement(){
      BooleanExpression expression = null;
      Block b1 = null;
      Token myToken = removeNextToken();
      if(myToken.getTokenType().equals("while_stmt"))
         expression = newBooleanExpression();
      myToken = removeNextToken();
      if(myToken.getTokenType().equals("do_stmt"))
         b1 = newBlock();
      WhileStatement tempWhile = new WhileStatement(expression, b1);
      return tempWhile;
   }
   
   public AssignmentStatement newAssignmentStatement(){
      ArithmeticExpression expression = null;
      Id id = newId();
      removeNextToken();
      expression = newArithmeticExpression();  
      AssignmentStatement tempAssign = new AssignmentStatement(expression, id);
      return tempAssign;
         
   }
      
   public RepeatStatement newRepeatStatement(){
      Block b1 = null;
      BooleanExpression expression = null;
      Token myToken = getNextToken();
      if(myToken.getTokenType().equals("repeat_stmt"))
         b1 = newBlock();
      myToken = removeNextToken();
      if(myToken.getTokenType().equals("until_stmt"))
         expression = newBooleanExpression();
      RepeatStatement tempRepeat = new RepeatStatement(b1, expression);
      return tempRepeat;
   }
   
   public PrintStatement newPrintStatement(){
      ArithmeticExpression expression = null;
      Token myToken = removeNextToken();
      if(myToken.getTokenType().equals("print_stmt"))
         expression = newArithmeticExpression();
      PrintStatement tempPrint = new PrintStatement(expression);
      return tempPrint;
   }
   
   public BooleanExpression newBooleanExpression(){   
      ArithmeticExpression expression1 = newArithmeticExpression();
      String op = removeNextToken().getTokenType();
      ArithmeticExpression expression2 = newArithmeticExpression();
      BooleanExpression tempBE = new BooleanExpression(expression1, op, expression2);
      return tempBE;
   }
   
   
   public ArithmeticExpression newArithmeticExpression(){
      ArithmeticExpression expression = null;
      Token myToken = getNextToken();
      if(myToken.getTokenType().equals("digit"))
         expression = getInt();
      else if(myToken.getTokenType().equals("ID"))
         expression = newId();
      else
         expression = newArithmeticOperator();
      return expression;
   }
   
   public ArithmeticOperator newArithmeticOperator(){
      ArithmeticExpression expression1 = newArithmeticExpression();
      String op = removeNextToken().getTokenType();
      ArithmeticExpression expression2 = newArithmeticExpression();
      ArithmeticOperator tempAO = new ArithmeticOperator(expression1, op, expression2);
      return tempAO;
   }
   
   public Id newId(){
      Token myToken = removeNextToken();
      Id id = new Id(myToken.getLexeme().charAt(0), valueOfId);
      return id;
   }
   
   public LiteralInteger getInt(){
      Token myToken = removeNextToken();
      LiteralInteger litInt = new LiteralInteger(Integer.parseInt(myToken.getLexeme()));
      return litInt;
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
   
   public Token getAfterToken(){
      return lexicalAnalyzer.getAfterToken();
      }
   
   public Token removeAfterToken(){
      return lexicalAnalyzer.removeAfterToken();
      }
   
   public Token getNextToken(){
      return lexicalAnalyzer.getNextToken();
   }
}