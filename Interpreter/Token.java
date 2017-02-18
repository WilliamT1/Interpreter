public class Token{
   private String lexeme;
   private String tokenType;
   
   public Token(String lexeme, String tokenType){
      this.lexeme = lexeme;
      this.tokenType = tokenType;
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
}