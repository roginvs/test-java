import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main6 {
    private static String SIN_FILENAME = "sin.txt";
    private static String INPUT_FILENAME = "input.txt";

    private static void createSinFile() throws FileNotFoundException {
        var pw = new PrintWriter(Main6.SIN_FILENAME);
        for (int degree = 0; degree < 360; degree++) {
            double rad = degree * Math.PI / 180;
            pw.println(Math.sin(rad));
        }
        pw.close();
    }

    private static void createInputFile() throws FileNotFoundException {
        int randomLineNumber = (int) (Math.floor(Math.random() * 360));
        var pw = new PrintWriter(Main6.INPUT_FILENAME);
        pw.println(randomLineNumber);
        pw.close();
    }

    private static void readFiles() throws FileNotFoundException, IOException {
        double[] values = new double[360];

        try (var br = new BufferedReader(new FileReader(Main6.SIN_FILENAME))) {
            for (int degree = 0; degree < 360; degree++) {
                String line = br.readLine();
                values[degree] = Double.parseDouble(line);
            }
        }

        int lineNum = -1;
        try (var br = new BufferedReader(new FileReader(Main6.INPUT_FILENAME))) {
            lineNum = Integer.parseInt(br.readLine());
        }

        var value = values[lineNum];
        System.out.println(String.format("Readed line %d = %f", lineNum, value));
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Main6.createSinFile();
        Main6.createInputFile();

        Main6.readFiles();
    }
}