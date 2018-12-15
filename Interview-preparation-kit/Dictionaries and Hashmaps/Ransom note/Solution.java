import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        
        //Word and number of repeat
        Map<String, Integer> wordsInMagz = new HashMap<>();
        for(int i=0; i < magazine.length;i++){
            if(wordsInMagz.containsKey(magazine[i])){
                wordsInMagz.put(magazine[i], wordsInMagz.get(magazine[i])+1);
            }else{
                wordsInMagz.put(magazine[i], 1);
            }          
        }

        for(int i=0; i < note.length;i++){
            if(!wordsInMagz.containsKey(note[i])){
                System.out.println("No");
                return;
            }else{
                if ( wordsInMagz.get(note[i]) == 1 ){
                    wordsInMagz.remove(note[i]);
                }else{
                    wordsInMagz.put(note[i], wordsInMagz.get(note[i])-1);
                }
            }
            
        }

        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
