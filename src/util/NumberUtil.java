package util;

public class NumberUtil {
    public static boolean isPrime(int n) { // n = 3
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) { // i <= 1
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}