import java.util.*;
//import src.DataStructure;


public class Algorithms {
    public static void main(String args[]){

    }
    /**
     * 1.----------------------------------------------------------------------------------
     *
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
        int s = 0;
        for(int i = 0; i < S.length(); i++){
            if(J.indexOf(S.charAt(i)) != -1)
                s++;
        }
        return s;
    }

    /**
     * 2.----------------------------------------------------------------------------------
     *
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
     *
     * Complexity: O(N), where N is the number of nodes in the tree.
     *
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

    /**
     *3.----------------------------------------------------------------------------------
     *
     * In a 2 dimensional array grid, each value grid[i][j] represents the height of a
     * building located there. We are allowed to increase the height of any number of buildings,
     * by any amount (the amounts can be different for different buildings). Height 0 is considered
     * to be a building as well.
     *
     * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top,
     * bottom, left, and right, must be the same as the skyline of the original grid. A city's
     * skyline is the outer contour of the rectangles formed by all the buildings when viewed
     * from a distance. See the following example.
     *
     * What is the maximum total sum that the height of the buildings can be increased?
     *
     * Example:
     * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
     * Output: 35
     * Explanation:
     * The grid is:
     * [ [3, 0, 8, 4],
     *   [2, 4, 5, 7],
     *   [9, 2, 6, 3],
     *   [0, 3, 1, 0] ]
     *
     * The skyline viewed from top or bottom is: [9, 4, 8, 7]
     * The skyline viewed from left or right is: [8, 7, 9, 3]
     *
     * The grid after increasing the height of buildings without affecting skylines is:
     *
     * gridNew = [ [8, 4, 8, 7],
     *             [7, 4, 7, 7],
     *             [9, 4, 8, 7],
     *             [3, 3, 3, 3] ]
     *
     * Complexity: O(N^2)
     *
     * @param grid
     * @return
     */
    public static int maxIncreasingKeepingSkyline(int[][] grid){
        int n = grid.length;
        int[] col = new int[n], row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;
    }

    /**
     * 4.----------------------------------------------------------------------------------
     *
     * Every email consists of a local name and a domain name, separated by the @ sign.
     *
     * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
     *
     * Besides lowercase letters, these emails may contain '.'s or '+'s.
     *
     * If you add periods ('.') between some characters in the local name part of an email address,
     * mail sent there will be forwarded to the same address without dots in the local name.
     * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
     * Note that this rule does not apply for domain names.)
     *
     * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
     * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
     * (Again, this rule does not apply for domain names.)
     *
     * It is possible to use both of these rules at the same time.
     *
     * Given a list of emails, we send one email to each address in the list.
     * How many different addresses actually receive mails?
     *
     *
     *
     * Example 1:
     *
     * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * Output: 2
     * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
     *
     *
     *
     * @param emails
     * @return
     */

    public static int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean isBeforePlus = true;
            int idxOfAt = 0;
            for (int i = 0; i < email.length(); i++) {
                if (isBeforePlus && email.charAt(i) != '@') {
                    if (email.charAt(i) == '.') {
                        continue;
                    } else if (email.charAt(i) == '+') {
                        isBeforePlus = false;
                    } else {
                        sb.append(email.charAt(i));
                    }
                } else if (email.charAt(i) == '@') {
                    idxOfAt = i;
                    break;
                }
            }
            sb.append(email.substring(idxOfAt));
            set.add(sb.toString());
        }

        return set.size();
    }

    /**
     * 5.----------------------------------------------------------------------------------
     *
     * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
     *
     * Example 1:
     * Input: "Hello"
     * Output: "hello"
     *
     * Example 2:
     * Input: "here"
     * Output: "here"
     *
     * Example 3:
     * Input: "LOVELY"
     * Output: "lovely"
     *
     *
     * @param str
     * @return
     */

    public static String toLowerCase(String str){
        int l = str.length();
        char[] c = str.toCharArray();
        for(int i = 0;i < l;i++) {
            if((c[i] <= 'Z')&&(c[i] >= 'A')){
                c[i] = (char)(str.charAt(i) + 32);
            }
        }
        return new String(c);
    }

    /**
     * 6.-------------------------------------------------------------------------------------
     *
     * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
     * and it returns a short URL such as http://tinyurl.com/4e9iAk.
     *
     * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
     * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
     * decoded to the original URL.
     *
     *
     */

    Map<Integer, String> map = new HashMap<>();
    private String encode(String longUrl) {
        map.put(longUrl.hashCode(),longUrl);
        return "http://tinyurl.com/"+longUrl.hashCode();
    }
    private String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    /**
     * 7.--------------------------------------------------------------------------------------
     *
     * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     *
     * Return the element repeated N times.
     *
     * Example 1:
     *
     * Input: [1,2,3,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,1,2,5,3,2]
     * Output: 2
     *
     * @param A
     * @return
     */
    private int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }


    /**
     * 8.----------------------------------------------------------------------------------------
     *
     * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value
     * into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does
     * not exist in the original BST.
     *
     * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after
     * insertion. You can return any of them.
     *
     * For example,
     *
     * Given the tree:
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     * And the value to insert: 5
     * You can return this binary search tree:
     *
     *          4
     *        /   \
     *       2     7
     *      / \   /
     *     1   3 5
     * This tree is also valid:
     *
     *          5
     *        /   \
     *       2     7
     *      / \
     *     1   3
     *          \
     *           4
     *
     * @param root
     * @param val
     * @return
     */
    private TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTUtil(root,val,new TreeNode(val));
    }

    private TreeNode insertIntoBSTUtil(TreeNode root, int val, TreeNode node) {
        if(root==null)
            return node;
        if(root.val > val)
            root.left=insertIntoBSTUtil(root.left,val,node);
        else
            root.right=insertIntoBSTUtil(root.right,val,node);
        return root;
    }




}
