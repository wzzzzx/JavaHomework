import jdk.internal.logger.BootstrapLogger;

import java.io.*;
import java.util.Scanner;

/**
 * @author 86176
 */
public class t1 {
    public static void main(String[] args) {
        File file = new File("E:\\学习资料\\Java\\Homework-io\\bw.txt");
/*
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("11111111\n");
            fileWriter.write("22222222\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        StringBuilder input = new StringBuilder();
        String text;
        try  {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((text = bufferedReader.readLine()) != null){
                input.append(text);
                input.append("\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(input);

    }
}
