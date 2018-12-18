import java.util.*;

public class Algorithms {
    public static void main(String args[]){
//        System.out.println(numJewelsInStones("aA","aAsAafna")); //output 5
    }
    /**
     * 1.
     *     You're given strings J representing the types of stones that are jewels, and S
     *     representing the stones you have.  Each character in S is a type of stone you have.
     *
     *     You want to know how many of the stones you have are also jewels.
     *
     *     The letters in J are guaranteed distinct, and all characters in J and S are letters.
     *
     *     Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     *     Example 1:
     *     Input: J = "aA", S = "aAAbbbb"
     *     Output: 3
     *
     *     Example 2:
     *     Input: J = "z", S = "ZZ"
     *     Output: 0
     */
    public static int numJewelsInStones(String J, String S) {
        int result = 0;
        HashMap jHash = new HashMap();
        for (int j = 0; j < J.length(); j++) {
            jHash.put(J.charAt(j), J.charAt(j));
        }
        for (int s = 0; s < S.length(); s++) {
            if (jHash.containsKey(S.charAt(s))) {
                result++;
            }
        }
        return result;
    }


}
