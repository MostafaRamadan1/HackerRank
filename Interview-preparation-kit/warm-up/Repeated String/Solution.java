import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long l = s.length();
        char[] letters = s.toCharArray();
        long totalRepeats = 0;
        long numberOfARepeationInGivenString = 0;
        long mod = n % l;
        long repeation = n / l;
        for(int i = 0 ; i < l ;i++){
            if(letters[i] == 'a'){
                if(mod > i){
                    totalRepeats++;
                }
                numberOfARepeationInGivenString++;
            }
        }

        totalRepeats += numberOfARepeationInGivenString*repeation;
        return totalRepeats;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
