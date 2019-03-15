package 线性表;

import java.util.Stack;

/**
 * 题目：
 *      给定字符串，仅由"()[]{}"六个字符组成。设 计算法，判断该字符串是否有效。
 * 解析方法：
 *  1、从前向后扫描字符串；
 *  2、遇到左括号x，就压栈x;
 *  3、遇到右括号y:
 *      如果发现栈顶元素x和该括号y匹配，则栈顶元素出栈，继续判断下一个字符
 *      如果栈顶元素x和该括号y不匹配，字符串不匹配；
 *      如果栈为空，字符串不匹配；
 *  4、扫描完成后，如果栈恰好为空，则字符串匹配，否则，字符串不匹配
 */
public class 括号是否匹配 {
    public static void main(String[] args) {
        String str="(({})[])[()]";
        boolean result=matchParentheses(str);

        System.out.println(result);
    }

    private static boolean matchParentheses(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = str.toCharArray();
        for (char current:chars) {
            if(isLeftParentheses(current)){
                stack.push(current);
            }else{
                if(stack.isEmpty() || !isMatch(stack.peek(),current)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(Character left, char current) {
        if(left=='('){
            return current==')';
        }
        if(left=='['){
            return current==']';
        }
        if(left=='{'){
            return current=='}';
        }
        return false;
    }

    private static boolean isLeftParentheses(char current) {
        return current=='(' || current=='[' || current=='{';
    }
}
