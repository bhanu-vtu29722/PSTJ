import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> list=new ArrayList<>();
       int n=arr.size();
       int sum1=0;
       int sum=arr.get(0);
       int maxsum=arr.get(0);
       for(int i=1;i<n;i++){
        sum=Math.max(sum+arr.get(i),arr.get(i));
        maxsum=Math.max(maxsum,sum);
       }
       list.add(maxsum);
       int maxElement=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
        if(arr.get(i)>0){
            sum1=sum1+arr.get(i);
        }   maxElement = Math.max(maxElement, arr.get(i));
        
        
       }
       
       if(sum1==0){
        list.add(maxElement);
       }else
       list.add(sum1);
return list;
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
