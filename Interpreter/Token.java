public class Token{
   private String lexeme;
   private String tokenType;
   private int lineNumber;
   
   public Token(String lexeme, String tokenType, int lineNumber){
      this.lexeme = lexeme;
      this.tokenType = tokenType;
      this.lineNumber = lineNumber;
   }
   
   public int getLineNumber(){
      return lineNumber;
   }
   
   public String getLexeme(){
      return lexeme;
   }
     
   public String getTokenType(){
      return tokenType;
   }
   
   public void setLexeme(String lexeme){
      this.lexeme = lexeme;
   }
   
   public void setTokenType(String tokenType){
      this.tokenType = tokenType;
   }
   
   public void setLineNumber(int lineNumber){
      this.lineNumber = lineNumber;
   }
}