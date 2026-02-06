import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static void miniMaxSum(List<Integer> arr) {
        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            long currentSum = 0;

            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    currentSum += arr.get(j);
                }
            }

            minSum = Math.min(minSum, currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(minSum + " " + maxSum);
    }


}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
