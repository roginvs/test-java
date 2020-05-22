import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main6 {
    private static String SIN_FILENAME = "sin.txt";
    private static String INPUT_FILENAME = "input.txt";

    private static void createSinFile() throws FileNotFoundException {
        try (var pw = new PrintWriter(Main6.SIN_FILENAME)) {
            for (int degree = 0; degree < 360; degree++) {
                double rad = degree * Math.PI / 180;
                pw.println(Math.sin(rad));
            }
        }

    }

    private static void createInputFile() throws FileNotFoundException {
        int randomLineNumber = (int) (Math.floor(Math.random() * 360));
        try (var pw = new PrintWriter(Main6.INPUT_FILENAME)) {
            pw.println(randomLineNumber);
        }

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

    private static void serializeObjects() throws IOException, ClassNotFoundException {
        System.out.println("Serializing array");

        var SERIALIZE_FILE_NAME = "sin2.dat";

        double[] values = new double[360];
        for (int degree = 0; degree < 360; degree++) {
            double rad = degree * Math.PI / 180;
            values[degree] = Math.sin(rad);
        }

        try (var oos = new ObjectOutputStream(new FileOutputStream(SERIALIZE_FILE_NAME))) {
            oos.writeObject(values);
        }

        System.out.println("Deserializing array");

        double[] valuesReaded = new double[360];
        try (var oos = new ObjectInputStream(new FileInputStream(SERIALIZE_FILE_NAME))) {
            valuesReaded = (double[]) oos.readObject();
        }

        System.out.println("Serializing one-by-one");

        var SERIALIZE_ONE_BY_ONE_FILE_NAME = "sin2-one-by-one.dat";
        try (var oos = new ObjectOutputStream(new FileOutputStream(SERIALIZE_ONE_BY_ONE_FILE_NAME))) {
            for (var value : values) {
                oos.writeObject(value);
            }
        }

        System.out.println("Deserializing one-by-one");

        double[] valuesOneByOneReaded = new double[360];
        try (var oos = new ObjectInputStream(new FileInputStream(SERIALIZE_ONE_BY_ONE_FILE_NAME))) {
            for (int i = 0; i < 360; i++) {
                valuesOneByOneReaded[i] = (double) oos.readObject();
            }
        }

        System.out.println("Checking");

        if (valuesReaded.length != values.length) {
            throw new Error("Not equal length for array serialization");
        }

        if (valuesOneByOneReaded.length != values.length) {
            throw new Error("Not equal length for one-by-one");
        }

        for (int i = 0; i < 360; i++) {
            if (values[i] != valuesReaded[i]) {
                throw new Error(String.format("Wrong value at pos %d for object serialization", i));
            }
            if (values[i] != valuesOneByOneReaded[i]) {
                throw new Error(String.format("Wrong value at pos %d for one-by-one serialization", i));
            }
        }

        System.out.println("All equal");

    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Main6.createSinFile();
        Main6.createInputFile();

        Main6.readFiles();

        Main6.serializeObjects();
    }
}