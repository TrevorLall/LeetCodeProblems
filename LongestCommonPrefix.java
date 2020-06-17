import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 *  Result:
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String output = "", currentLetter = "";
        //sort array shortest length first
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        //loop through array, comparing to shorted length
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                char c = strs[0].charAt(i);
                if (j == 0) {
                    currentLetter = "" + c;
                }
                if (strs[j].charAt(i) != c) {
                    return output;
                }
            }
            output += currentLetter;
        }
        //return output
        return output;
    }

    public static void main(String[] args) {
        String[] str = { "flower", "flow", "flight" };
        String[] str2 = { "dog", "racecar", "car" };

        String output = longestCommonPrefix(str);
        System.out.println(output);
        output = longestCommonPrefix(str2);
        System.out.println(output);

    }

}