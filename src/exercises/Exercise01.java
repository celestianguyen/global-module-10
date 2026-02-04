package exercises;

import util.ArrayUtil;
import util.InputUtil;
import util.NumberUtil;

import java.util.Arrays;
import java.util.Scanner;

import static util.InputUtil.readInt;

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
        while (true) {
            printMenu();
            int choice = InputUtil.readInt("Please choose an option: ");
            switch (choice) {
                case 0:
                    System.out.println("Exit");
                    return;
                case 1:
                    int[] e = extractPrimes(a);
                    System.out.println("a) Prime numbers b = " + Arrays.toString(e));
                    break;
                case 2:
                    int[] b = extractPositive(a);
                    int[] c = extractRem(a);
                    System.out.println("b) Positive b = " + Arrays.toString(b));
                    System.out.println("   Remaining c = " + Arrays.toString(c));
                    break;
                case 3:
                    int[] copy = Arrays.copyOf(a, a.length);
                    descSort(copy);
                    System.out.println("c) Desc sorted = " + Arrays.toString(copy));
                    break;
                case 4:
                    int[] arranged = sortPosNeg(a);
                    System.out.println("d) Positive descending, negative ascending, zero last = " + Arrays.toString(arranged));
                    break;
                case 5:
                    int[] cp = Arrays.copyOf(a, a.length);
                    reverse(cp);
                    System.out.println("e) Reversed = " + Arrays.toString(cp));
                    break;
                case 6:
                    System.out.println("f) Palindrome? " + isPalindrome(a));
                    break;
                case 7:
                    System.out.println("g) Symmetric pairs = " + countSymmetricPairs(a));
                    break;
                default:
                    System.out.println("Invalid input. You must enter an integer from 0-7.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
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

    private static int[] inputArray(String prompt) {
        int n = InputUtil.readIntMin(prompt, 1);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = InputUtil.readInt("a[" + i + "] = ");
        }
        return a;
    }

    // a. Extract all prime numbers from array a and store them in array b.
    private static int[] extractPrimes(int[] a) {
        int[] e = new int[0];
        for (int value : a) {
            if (NumberUtil.isPrime(value)) {
                e = ArrayUtil.add(e, value);
            }
        }
        return e;
    }

    //b) Split array a into two arrays: b contains all positive numbers, c contains remaining numbers
    private static int[] extractPositive(int[] a) {
        int[] b = new int[0];
        for (int value : a) {
            if (value > 0) {
                b = ArrayUtil.add(b, value);
            }
        }
        return b;
    }

    private static int[] extractRem(int[] a) {
        int[] c = new int[0];
        for (int value : a) {
            if (value <= 0) {
                c = ArrayUtil.add(c, value);
            }
        }
        return c;
    }

    // c. Sort the array in descending order.
    private static void descSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = (i + 1); j < a.length; j++) {
                if (a[j] > a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // d. Sort the array so that:
    //    • Positive numbers come first in descending order
    //    • Negative numbers come next in ascending order
    //    • Zeros come last
    private static int[] sortPosNeg(int[] a) {
        int[] pos = new int[0];
        int[] neg = new int[0];
        int zeroCount = 0;

        for (int v : a) {
            if (v > 0) {
                pos = ArrayUtil.add(pos, v);
            } else if (v < 0) {
                neg = ArrayUtil.add(neg, v);
            } else zeroCount++;
        }

        descSort(pos);
        ascSort(neg);

        int[] res = new int[pos.length + neg.length + zeroCount];
        int k = 0;
        for (int v : pos) {
            res[k++] = v;
        }
        for (int v : neg) {
            res[k++] = v;
        }
        while (zeroCount-- > 0) {
            res[k++] = 0;
        }

        return res;
    }
    private static void ascSort (int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
    // e) reverse
    private static void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    // f) palindrome
    private static boolean isPalindrome(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != a[a.length - 1 - i]) return false;
        }
        return true;
    }
    // g) symmetric pairs count (equal mirrored values)
    private static int countSymmetricPairs(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] == a[a.length - 1 - i]) {
                count++;
            }
        }
        return count;
    }

}
