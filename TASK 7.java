interface DigitSum {
    int calculate(int n);
}

public class Task7 {
    public static void main(String[] args) {

        DigitSum evenSum = n -> {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                if (d % 2 == 0) sum += d;
                n /= 10;
            }
            return sum;
        };

        DigitSum oddSum = n -> {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                if (d % 2 != 0) sum += d;
                n /= 10;
            }
            return sum;
        };

        System.out.println("Even digit sum: " + evenSum.calculate(12345));
        System.out.println("Odd digit sum: " + oddSum.calculate(12345));
    }
}
