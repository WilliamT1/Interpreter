import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Interpreter{
   public static void main(String[] args) throws FileNotFoundException, IOException{
      Parser myParser = new Parser("example.txt");
      Program p = myParser.parse();
      p.run();     
   }
}