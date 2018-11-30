import java.io.*;
import java.util.*;
import java.util.function.BinaryOperator;

/**
 * Problem URL : https://www.hackerrank.com/challenges/sherlock-and-valid-string/
 */
public class Solution {

    static String isValid(String s) {

        char[] letters = s.toCharArray();
        Map<Character, Integer> letterRepeatedTimes = new HashMap<>();

        //init a map to represent a letter and how many repeated time
        for(int i=0;i< letters.length;i++){
            if(letterRepeatedTimes.containsKey(letters[i])){
                int r = letterRepeatedTimes.get(letters[i])+1;
                letterRepeatedTimes.put(letters[i], r);
            }else{
                letterRepeatedTimes.put(letters[i], 1);
            }
        }

        //loop via letterRepeatedTimes to find out the most repeated number
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : letterRepeatedTimes.entrySet())
        {
            list.add( entry.getValue() );
        }

        Integer mostFrequented = list.stream().reduce(BinaryOperator.maxBy((o1, o2) ->
                Collections.frequency(list, o1) - Collections.frequency(list, o2))).orElse(null);

        int diff = 0;
        int toBeDeleted= 0;
        for (Integer number: list) {
            diff = Math.abs(mostFrequented - number);
            if(diff > 0) {
                if (diff == 1 || number == 1) {//it may be deleted
                    toBeDeleted++;
                } else {
                    return "NO";
                }
            }
        }
        if(toBeDeleted > 1) return  "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
