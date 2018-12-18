import java.util.*;

public class Algorithms {
    public static void main(String args[]){
//        System.out.println(numJewelsInStones("aA","aAsAafna")); //output 5
//        System.out.println(rangeSumBST([10,5,15,3,7,13,18,1,null,6],7,15)); //output 32
    }
    /**
     * 1.
     * You're given strings J representing the types of stones that are jewels, and S
     * representing the stones you have.  Each character in S is a type of stone you have.
     *
     * You want to know how many of the stones you have are also jewels.
     *
     * The letters in J are guaranteed distinct, and all characters in J and S are letters.
     *
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Example 1:
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     *
     * Example 2:
     * Input: J = "z", S = "ZZ"
     * Output: 0
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

    /**
     * 2.
     * Given the root node of a binary search tree, return the sum of
     * values of all nodes with value between L and R (inclusive).
     *
     * The binary search tree is guaranteed to have unique values.
     *
     * Example 1:
     *
     * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
     * Output: 32
     * Example 2:
     *
     * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * Output: 23
     */

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }


}
