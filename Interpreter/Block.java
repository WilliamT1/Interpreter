import java.util.ArrayList;
import java.util.List;
public class Block{
   private List<Statement> ourStatements;
   public Block(){
      ourStatements = new ArrayList<Statement>();
   }
      
   public void addStatement(Statement statement){
      ourStatements.add(statement);
   }
      
   public void run(){
      for(int i = 0; i < ourStatements.size(); i++)
         ourStatements.get(i).run();
   }
}