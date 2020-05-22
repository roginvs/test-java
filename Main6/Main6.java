import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Main6 {
    private static String SIN_FILENAME = "sin.txt";
    private static String INPUT_FILENAME = "input.txt";

    private static void createSinFile() throws FileNotFoundException {
        var pw = new PrintWriter(Main6.SIN_FILENAME);
        for (int degree = 0; degree < 360; degree++) {
            double rad = degree * Math.PI / 180;            
            pw.println(Math.sin(rad));
        };        
        pw.close();
    }

    private static void createInputFile() throws FileNotFoundException {        
        int randomLineNumber = (int)(Math.floor(Math.random() * 360));
        var pw = new PrintWriter(Main6.INPUT_FILENAME);
        pw.println(randomLineNumber);
        pw.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        Main6.createSinFile();
        Main6.createInputFile();
    }
}