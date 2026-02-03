import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        Arrays.sort(arr);
        System.out.println("Kth smallest = " + arr[k - 1]);
    }
}
