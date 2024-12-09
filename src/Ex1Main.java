import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            int input1 = 0;
            int input2 = 0;
            if (!num1.equals("quit")) {
                input1 =Ex1.number2Int(num1);
                System.out.println("num1=" + num1 + "is number: true , value    :" + input1);
            }
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc1.next();
            if (!num2.equals("quit")) {
                input2 =Ex1.number2Int(num2);
                System.out.println("num2=" + num2 + "is number: true , value    :" + input2);
            }
            if (num2.equals("quit")) {

            }
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter a base for output: (a number [2,16]");
            int base = sc2.nextInt();
            int add = input1 + input2;
            int multiply = input1 * input2;
            String add1;
            String multiply1;
            add1=Ex1.int2Number(add, base);
            multiply1=Ex1.int2Number(multiply, base);
            System.out.println(num1 + "+" + num2 + "=" + add1);
            System.out.println(num1 + "*" + num2 + "=" + multiply1);
        }
        System.out.println("quiting now...");
    }
}
