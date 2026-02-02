package exercises;

import java.util.Arrays;
import java.util.Scanner;

/*
Array Processing Operations
Problem
Perform the following operations on a one-dimensional array a:

a. Extract all prime numbers from array a and store them in array b.
b. Split array a into two arrays:
    • b contains positive integers
    • c contains the remaining elements
c. Sort the array in descending order.
d. Sort the array so that:
    • Positive numbers come first in descending order
    • Negative numbers come next in ascending order
    • Zeros come last
e. Reverse the order of elements in array a.
f. Check whether array a is a palindrome array.
     Example of a palindrome array: {1, 2, 4, 7, 3, 7, 4, 2, 1}
g. Count the number of symmetric pairs in the array.
     Example: {1, 2, 8, 7, 3, 7, 4, 2, 1}
          This array has 3 symmetric pairs.
 */
public class Exercise01 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = inputArray("Please enter length n of the array (n > 0): ");
        printMenu();
        int choice = readInt("Please choose an option: ");
        switch (choice){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid input. You must enter an integer from 0-7.");
        }


    }
    private static void printMenu(){
        System.out.println("=== Array Processing Operation ===");
        System.out.println("1) Extract all prime numbers from array a and store them in array b.");
        System.out.println("2) Split array a into two arrays:\n" +
                "    • b contains positive integers\n" +
                "    • c contains the remaining elements");
        System.out.println("3) Sort the array in descending order.");
        System.out.println("4) Sort the array so that:\n" +
                "    • Positive numbers come first in descending order\n" +
                "    • Negative numbers come next in ascending order\n" +
                "    • Zeros come last");
        System.out.println("5) Reverse the order of elements in array a.");
        System.out.println("6) Check whether array a is a palindrome array.");
        System.out.println("7) Count the number of symmetric pairs in the array.");
        System.out.println("0) Exit");
    }
    private static int[] inputArray(String prompt){
        int n = readInt(prompt);
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = readInt("a[" + i + "] = ");
        }
        return a;

    }
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String sInt = scanner.nextLine().trim();
            try {
                int iParsed = Integer.parseInt(sInt);
                if (iParsed <= 0){
                    System.out.println("Invalid input! Please enter a positive integer.");
                    continue;
                }
                return iParsed;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer only!");
            }
        }
    }


}
