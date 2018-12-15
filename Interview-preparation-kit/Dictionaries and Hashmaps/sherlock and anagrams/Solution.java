import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class Solution {
  

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int counter = 0;
        Map<String, Integer> map = new HashMap<>();
        // i indicates the size of sub strings
        for(int i = 1; i < s.length();i++){

            for(int j = 0;j < s.length() ;j++){
                if(j+i > s.length()) continue;
                String s1 = s.substring(j,j+i);
                char[] ArrayS1 = s1.toLowerCase().toCharArray();
                Arrays.sort(ArrayS1);
                String sorted =  new String(ArrayS1);

                if(map.containsKey(sorted)){
                   map.put(sorted, map.get(sorted)+1);
                }else{
                    map.put(sorted, 1);
                }

            }
        }
        Set<Map.Entry<String, Integer>> entryset = map.entrySet();
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            // (n * (n-1))/2
            counter +=  (entry.getValue()*(entry.getValue()-1))/2;
        }

        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
