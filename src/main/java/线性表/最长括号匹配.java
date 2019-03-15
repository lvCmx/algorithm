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
        int length=getLongestParenthese2(str);
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
    public static int getLongestParenthese2(String str){
        if(str==null || str.length()<=0){
            return 0;
        }
        char[] arrs = str.toCharArray();
        int deep=0;     //遇到了多少左括号
        int answer=0;   //最终解
        int start=-1;
        for(int i=0;i<arrs.length;i++){
            if(arrs[i]=='('){
                deep++;
            }else{
                deep--;
                if(deep==0){
                    answer=Math.max(answer,i-start);
                }else if(deep<0){  //说明右括号数目大于左括号，初始化为for循环前
                    deep=0;
                    start=i;
                }
            }
        }

        deep=0; //遇到了多少右括号
        start= arrs.length; //最深的deep=0时，右括号的位置
                            //其实，为了方便计算长度，该亦是是最深右括号的后一个位置。
        for(int i=arrs.length-1;i>=0;i--){
            if(arrs[i]==')'){
                deep++;
            }else{
                deep--;
                if(deep==0){
                    answer=Math.max(answer,start-i);
                }else if(deep<0){  //说明右括号数目大于左括号，初始化为for循环前
                    deep=0;
                    start=i;
                }
            }
        }
        return answer;
    }
}
