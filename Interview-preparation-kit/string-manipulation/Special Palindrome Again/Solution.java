import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//URL:https://www.hackerrank.com/challenges/special-palindrome-again/problem
public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char[] chars = s.toCharArray();
        long count = chars.length;
        for(int i = 0; i < chars.length ;i++){
            char startChar = chars[i];
            boolean diffCharDetected = false;
            int balancedIndex = -1;
            for(int j = i+1; j < chars.length ; j++){
               char currentChar = chars[j];
               if(startChar == currentChar){
                  if(balancedIndex == -1 || ( j - balancedIndex == balancedIndex -i ) ){
                    count++; 
                  }
				  //improvement to avoid loop until the end of array
                  if(balancedIndex > -1 && (j - balancedIndex > balancedIndex -i)){
                      break;
                  }
               } else{
                   if(diffCharDetected){
                       break;
                   }else{
                        diffCharDetected = true;
                        balancedIndex = j;
                   }

               }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
