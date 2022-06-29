package vttp.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//java vttp.d4.IOMain exams.csv C:\Users\....

public class IOMain {
    public static void main(String[] args) {
        String srcFile = args[0];
        String dstFile = args[1];

        byte[] buff = new byte[1024*16];
        int size = 0;

        try {
            InputStream is = new FileInputStream(srcFile);
            System.out.printf("%s file opened\n", srcFile);
            
            OutputStream os = new FileOutputStream(dstFile); 
            
            while (size >= 0) {
                size = is.read(buff);
                System.out.printf("Read: %d\n", size);
                if (size > 0) {
                    os.write(buff, 0, size);
                }
            }

            is.close();
            os.flush();
            os.close();

        } catch (FileNotFoundException ex) {
            System.err.printf("Error: %s\n", ex.getMessage()); //getMessage give exception message
        } catch (IOException ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
        }
    }
    
}
