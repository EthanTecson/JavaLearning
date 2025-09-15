import java.util.Scanner;
import java.io.*;

public class Example {
    private int number = 1;
    private final Object lock = new Object();
    private boolean turnA = true;

    public static void main(String[] args) {
        Example ap = new Example();

        Runnable taskA = () -> ap.printNumbers(true);
        Runnable taskB = () -> ap.printNumbers(false);

        new Thread(taskA).start();
        new Thread(taskB).start();
    }

    private void printNumbers(boolean isA) {
        while (true) {
            synchronized (lock) {
               while (turnA != isA && number <= 10) {
                try { lock.wait(); } catch(InterruptedException e) {}
               }

               if (number > 10) {
                lock.notifyAll();
                break;
               }

               System.out.println(Thread.currentThread().getName() + " -> " + number);
               number++;
               turnA = !turnA;
               lock.notifyAll();
            }
        }
    }
}