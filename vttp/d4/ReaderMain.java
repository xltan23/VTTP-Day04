package vttp.d4;

import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReaderMain {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Source File
        String srcFile = args[0];

        Reader reader = new FileReader(srcFile);
        BufferedReader br = new BufferedReader(reader);

        String line = "";
        Integer lineNum = 0;

        while (line != null) {
            line = br.readLine();
            lineNum++;
            System.out.printf("%d : %s\n",lineNum ,line.toUpperCase());
        }

        reader.close();
    }
    
}
