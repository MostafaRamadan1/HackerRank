import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//URL: https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int numOfBribes = 0;
        int[] simulationQueue = new int[q.length];
        for(int i=0;i<q.length;i++){
            simulationQueue[i] = i+1;
        }
        for(int i=0;i<q.length;i++){
            int suposedPerson = i+1;
            int currentPerson = q[i];
            if((currentPerson - suposedPerson) > 2){
                System.out.println("Too chaotic");
                return;
            }   

            if(currentPerson != simulationQueue[i]){
                int index = getIndex(currentPerson, i, -1, simulationQueue);
                int diff = index - i;
                
                int[] b = Arrays.copyOfRange(simulationQueue, i, i+diff);
                simulationQueue[i] = currentPerson;
                for(int j = 0;j < b.length;j++){
                    simulationQueue[i+j+1] = b[j];
                }
                numOfBribes += diff;
            }

        }
        System.out.println(numOfBribes+"");
    }

    static int getIndex(int num, int start, int end, int[] arr){
        for(int i=start;i<arr.length;i++){
            if(num == arr[i]){
                return i;
            }
        }
        return -1;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
