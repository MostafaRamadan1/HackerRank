import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int numOfMatchedPairs = 0;
        
        //HASH SET SOLUTION
        /*
        Set<Integer> pairs = new HashSet<>();
        for(int i=0; i < ar.length;i++)
        {
            if(pairs.contains(new Integer(ar[i]))){
                pairs.remove(new Integer(ar[i]));
                numOfMatchedPairs++;
            }else{
                pairs.add(new Integer(ar[i]));
            }
        }
        */
        

        //HASH MAP SOLUTION
        //Map<SockNumber, Repeation>
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i=0; i < ar.length;i++)
        {
            if(pairs.containsKey(new Integer(ar[i]))){
                int reps = pairs.get(new Integer(ar[i]));
                reps++;
                pairs.put(new Integer(ar[i]), new Integer(reps));
            }else{
                pairs.put(new Integer(ar[i]), new Integer(1));
            }
        }

      
        for (Map.Entry<Integer, Integer> entry : pairs.entrySet())
        {
            numOfMatchedPairs +=  entry.getValue() / 2 ;
        }

        return numOfMatchedPairs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
