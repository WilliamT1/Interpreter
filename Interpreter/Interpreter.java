import java.util.List;
import java.io.FileNotFoundException;
public class Interpreter{
   public static void main(String[] args) throws FileNotFoundException{
      Parser myParser = new Parser("example.txt");
      
      myParser.parse();
   }
}