import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        int n = arr.size();
        Map<Long, Integer> right = new HashMap<>();
        Map<Long, Integer> left = new HashMap<>();

        for (int i = 0; i < n; i++)
            right.put(arr.get(i), right.getOrDefault(arr.get(i), 0)+1);

        for (int i = 0; i < n; i++){
            long l1 = 0, r1 =0l;
            long cn = arr.get(i);
            if(cn % r == 0){
                l1 = left.getOrDefault((cn/r), 0);
            }

            right.put(cn, right.get(cn)-1);

            // number of right elements
            r1 = right.getOrDefault((cn*r), 0);

            // calculate the answer
            count += l1 * r1;

            // left count of a[i]
            left.put(cn, left.getOrDefault( cn, 0)+1);

        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
