import java.util.function.IntSupplier;

public class Task8 {
    public static void main(String[] args) {
        int n = 10;

        IntSupplier fib = () -> {
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            return n == 0 ? 0 : b;
        };

        System.out.println("Fibonacci(" + n + ") = " + fib.getAsInt());
    }
}
