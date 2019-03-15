package 线性表;

import java.util.Stack;

/**
 * 题目：
 *  给定字符串，仅包含左括号‘(’和右括号 ‘)’，它可能不是括号匹配的，设计算法， 找出最长匹配的括号子串，返回该子串的长 度。
 * 例如：
 *  (():2
 *  ()():4
 *  ()(()):6
 *  (()()):6
 */
public class 最长括号匹配 {

    public static void main(String[] args) {
        String str="()((()))";
        int length=getLongestParenthese(str);
        System.out.println(length);
    }

    /**
     * 返回最长括号匹配，利用栈来做，需要空间复杂度O(n)
     * @param str
     * @return
     */
    private static int getLongestParenthese(String str) {
        if(str==null || str.length()<=0){
            return 0;
        }

        int sum=0;
        int start=-1;
        Stack<Integer> stack = new Stack();
        char[] arrays = str.toCharArray();
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]=='('){
                stack.push(i);
            }else{
                // 否则为)
                stack.pop();
                if(stack.isEmpty()){
                    sum=Math.max(sum,i-start);
                }else{
                    sum=Math.max(sum,i-stack.peek());
                }
            }
        }
        return sum;
    }

    /**
     * 空间复杂度为O(1)
     */

}
