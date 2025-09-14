import java.util.Scanner;
import java.io.*;

public class HelloWorld {

    // public int runFactorial(int num) {
    //     int res = 1;
    //     for (int i = num; i >= 1; i--) {
    //         res *= i;
    //     }
    //     return res;
    // }
    // public static void main(String args[]) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.println("Enter your number: ");
    //     int input = scanner.nextInt();

    //     HelloWorld object = new HelloWorld();
    //     System.out.println(object.runFactorial(input));

    //     scanner.close();
    // }
    public static void main(String[] args) {

        String fileName = "output.txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("This is line number 1");
            writer.write("\nThis is line number 2");
            writer.write("\nThis is line number 3");
            System.out.println("File written!");
        } catch (IOException e) {
            System.out.println("An error occured when writing the file: " + e.getMessage());
        }

        try {
            BufferedReader brfo = new BufferedReader(new FileReader("./output.txt"));

            String st;
            int numberOfLines = 0;

            while ((st = brfo.readLine()) != null) {
                System.out.println(st);
                numberOfLines++;
            }

            System.out.println("There are " + numberOfLines + " lines in this file!");

            brfo.close();
       } catch(IOException e) {
            System.out.println("File not found.");
       }

    }

}