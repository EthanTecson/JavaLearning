import java.util.Scanner;

public class HelloWorld {

    public int runFactorial(int num) {
        int res = 1;
        for (int i = num; i >= 1; i--) {
            res *= i;
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your number: ");
        int input = scanner.nextInt();

        HelloWorld object = new HelloWorld();
        System.out.println(object.runFactorial(input));

        scanner.close();
    }
}