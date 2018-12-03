import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL: https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] a) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < 4;i++){
            for(int j = 0; j < 4;j++){
                int result = getSumOfHourGlass(a, i, j);
                if(result > sum)
                    sum = result;
            }    
        }

        return sum;
    }

    static int getSumOfHourGlass(int[][] a, int i, int j){
        int sum = a[i][j]+a[i][j+1]+a[i][j+2]+
                   a[i+1][j+1]+
                   a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
        return sum;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
