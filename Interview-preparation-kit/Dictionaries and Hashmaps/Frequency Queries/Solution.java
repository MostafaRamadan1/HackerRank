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

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {

        Map<Integer, Integer> numberToFreq = new HashMap();
        Map<Integer, Set<Integer>> freqToNumbers = new HashMap();
        
        List<Integer> result = new ArrayList<>();
        for( int i = 0; i < queries.length ;i++){
            int[] op = queries[i];
            int op_type = op[0];
            Integer num = op[1];

            if(op_type == 1){

                int new_freq =  numberToFreq.getOrDefault(num, 0)+1;
                int old_freq =new_freq -1;
                //update
                numberToFreq.put(num, numberToFreq.getOrDefault(num, 0)+1);

                //Add it in thte new repeation catagory
                Set<Integer> s = freqToNumbers.getOrDefault(new_freq, new HashSet<>());
                s.add(num);
                freqToNumbers.put(new_freq, s);
                
                //Remove it from the old repeatation catagory
                Set<Integer> ss = freqToNumbers.getOrDefault(old_freq, new HashSet<>());
                ss.remove(num);
                freqToNumbers.put(old_freq, ss);

            }else if(op_type == 2){ 
                if(numberToFreq.containsKey(num)){
                    int new_freq =  numberToFreq.get(num) -1;
                    int old_freq =  numberToFreq.get(num);

                    if(new_freq == 0){
                        numberToFreq.remove(num);
                    }else{
                        numberToFreq.put(num, new_freq);
                        //Add it in thte new repeation catagory
                        Set<Integer> s = freqToNumbers.getOrDefault(new_freq, new HashSet<>());
                        s.add(num);
                        freqToNumbers.put(new_freq, s);
                    }

                    //Remove it from the old repeatation catagory
                    Set<Integer> ss = freqToNumbers.getOrDefault(old_freq, new HashSet<>());
                    ss.remove(num);
                    freqToNumbers.put(old_freq, ss);
                }
            }else{
                if(freqToNumbers.get(num) != null && !freqToNumbers.get(num).isEmpty()){
                        result.add(1);
                }else{
                    result.add(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
