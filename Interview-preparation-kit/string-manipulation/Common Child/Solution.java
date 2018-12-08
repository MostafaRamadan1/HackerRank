import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
*This Problem is based on Longest common subsequence problem
*youtube link : https://www.youtube.com/watch?v=HgUOWB0StNE
*
*URL: https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
*/
public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int m = s1Arr.length;
        int n = s2Arr.length;
        int[][] L= new int[m+1][n+1];

        for(int i=0; i <= m; i++ ){  
            for(int j=0; j <= n; j++){
                if(i == 0 || j == 0){
                    L[i][j] = 0;
                }else if(s1Arr[i-1] == s2Arr[j-1] ){
                    L[i][j] = L[i-1][j-1] +1; 
                }else {
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }    
        }

        return L[m][n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
	