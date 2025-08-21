import java.util.Scanner;

public class HelloWorld {

    public int addTwo(int num1, int num2) {
        return (num1 + num2);
    }

    static void printThis() {
        System.out.println("Geeks for Geeks");
    }

    public static void main(String args[]) {
        int x = 1;
        int y = 1;
        HelloWorld myHelloWorldObject = new HelloWorld();
        int result = myHelloWorldObject.addTwo(x,y);
        System.out.println(result);

        printThis();
    }
}