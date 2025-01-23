package vttp.d4;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ExamsMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String srcFile = args[0];

        Exams reporter = new Exams();

        Reader r = new FileReader(srcFile);
        BufferedReader br = new BufferedReader(r);
        String data = br.readLine();
        
        reporter.initializeList();
        while (data != null) {
            data = br.readLine();
            reporter.read(data);
        }
        reporter.createDataset();
        reporter.report();

    }
}
