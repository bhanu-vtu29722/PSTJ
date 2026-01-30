import java.util.function.IntPredicate;

public class Task9 {
    public static void main(String[] args) {
        IntPredicate isPalindrome = n -> {
            int temp = n, rev = 0;
            while (n > 0) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            return temp == rev;
        };

        System.out.println(isPalindrome.test(121));
        System.out.println(isPalindrome.test(123));
    }
}
