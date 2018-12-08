import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] aLetters = a.toCharArray();
        char[] bLetters = b.toCharArray();
        int[] indexedAlphabetical = new int[28];
        int max = Math.max(aLetters.length, bLetters.length);
        for(int i = 0; i < max ;i++ ){
            if( i < aLetters.length){
                char r = aLetters[i];
                int index = r - 'a';
                indexedAlphabetical[index]++;
            }   
            if( i < bLetters.length ){
                char r = bLetters[i];
                int index = r - 'a';
                indexedAlphabetical[index]--;
            }
        }

        int charToBeDeleted = 0;
        for(int i = 0; i < indexedAlphabetical.length ;i++){
           charToBeDeleted += Math.abs(indexedAlphabetical[i]);
        }

        return charToBeDeleted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
