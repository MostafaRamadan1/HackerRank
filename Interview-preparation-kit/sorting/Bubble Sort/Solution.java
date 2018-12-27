import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSwaps function below.
    static int numberOfSwaps = 0;
    static void countSwaps(int[] a) {
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i =0; i < a.length-1 ;i++){
                if(a[i] > a[i+1]){
                     swap(a, i, i+1 ); 
                     isSorted =false;
                }
            }
        }
        System.out.println("Array is sorted in "+numberOfSwaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);
    }

    static void swap(int[] a, int x, int y){
        int temp = a[y];
        a[y] = a[x];
        a[x] = temp;
        numberOfSwaps++;
    } 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
