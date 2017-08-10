import java.math.BigInteger;

public class Fibonacci {
    private static int odd = 0;
    private static int even = 0;
    private static int searchedNumber = 0;
    private static BigInteger searchedValue = new BigInteger("0");

    private static void fibonacci(BigInteger prev, BigInteger next, int count) {
        if (count > 0) {
            if (prev.mod(new BigInteger("2")).equals(new BigInteger("0"))) {
                even++;
            } else {
                odd++;
            }
            if (searchedNumber == count) {
                searchedValue = prev;
            }
            System.out.println(prev);
            fibonacci(next, prev.add(next), count - 1);
        }
        return;
    }

    public static void fibonacci(int count, int searchNumber) {
        searchedNumber = count - searchNumber + 1;
        fibonacci(BigInteger.ONE, BigInteger.ONE, count);
        System.out.println("odd: " + odd + "  even: " + even);
        System.out.println("odd: " + odd * 100.0 / count + "%  even: " + even * 100.0 / count + "%");
        System.out.println("searchedNumber: " + searchedValue);
    }
}
