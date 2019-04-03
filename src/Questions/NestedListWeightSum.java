package Questions;//import src.Questions.NestedInteger;

import java.util.*;
//import src.DataStructure.DataStructure;


interface NestedInteger {

    // @return true if this Questions.NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this Questions.NestedInteger holds, if it holds a single integer
    // Return null if this Questions.NestedInteger holds a nested list
     Integer getInteger();

    // Set this Questions.NestedInteger to hold a single integer.
     void setInteger(int value);

    // Set this Questions.NestedInteger to hold a nested list and adds a nested integer to it.
     void add(NestedInteger ni);

    // @return the nested list that this Questions.NestedInteger holds, if it holds a nested list
    // Return null if this Questions.NestedInteger holds a single integer
     List<NestedInteger> getList();
}

public class NestedListWeightSum {
    public static void main(String args[]){

    }

    /**
     * ----------Nested List Weight Sum-------------
     *
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     *
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     *
     * Example 1:
     * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
     *
     * Example 2:
     * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
     */

    private int depthSum(List<NestedInteger> nestedList){
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth){
        if(nestedList==null||nestedList.size()==0)
            return 0;

        int sum=0;
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                sum += helper(ni.getList(), depth+1);
            }
        }

        return sum;
    }







}
