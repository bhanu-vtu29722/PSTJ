import java.util.Scanner;

interface Perform {
    boolean check(int n);
}

class Verify {

    static Perform isOdd() {
        return n -> n % 2 != 0;
    }

    static Perform isPrime() {
        return n -> {
            if (n <= 1) return false;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }

    static Perform isPalindrome() {
        return n -> {
            int rev = 0, temp = n;

            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            return rev == n;
        };
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int type = sc.nextInt();
            int num = sc.nextInt();

            if (type == 1) {
                System.out.println(isOdd().check(num) ? "ODD" : "EVEN");
            }
            else if (type == 2) {
                System.out.println(isPrime().check(num) ? "PRIME" : "COMPOSITE");
            }
            else {
                System.out.println(
                        isPalindrome().check(num)
                                ? "PALINDROME"
                                : "NOT PALINDROME"
                );
            }
        }
        sc.close();
    }
}