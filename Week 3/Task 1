import java.util.Scanner;

public class SmallestAndLargest {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        int n = s.length()-k + 1;
        String[] arr = new String[n];

        for(int i=0; i<=s.length()-k; i++){
                arr[i] = s.substring(i, i+k);
        }

        smallest = arr[0];
        largest = arr[0];
        for(int i=1; i<arr.length; i++){
                if(arr[i].compareTo(smallest) < 0){
                        smallest = arr[i];
                }else if(arr[i].compareTo(largest) > 0){
                        largest = arr[i];
                }
        }
        
        return smallest + "\n" + largest;
    }
}
