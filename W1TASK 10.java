import java.util.function.BiFunction;

public class Task10 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> lastDigitSum =
                (a, b) -> (a % 10) + (b % 10);

        System.out.println(lastDigitSum.apply(123, 789));
    }
}
