package 线性表;

import java.util.Stack;

/**
 * 入栈出栈问题：
 *  给定无重复元素的两个等长数组，分别表述 入栈序列和出栈序列，请问:这样的出栈序 列是否可行。
 *  入栈序列为：ABCDEFG，出栈序列为BAEDFGC
 *
 *  使用一个堆栈S来模拟压栈出栈的操作，记入栈序列为A，出栈序列为B
 */
public class 入栈出栈问题 {
    public static void main(String[] args) {
        String strIn="ABCDEFG";
        String strOut="BAEDFGC";
        boolean result=isPossible(strIn,strOut);
        System.out.println(result);
    }

    private static boolean isPossible(String strIn, String strOut) {
        if(strIn==null || strOut==null){
            return false;
        }
        char[] arrIn = strIn.toCharArray();
        char[] arrOut = strOut.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        int inIndex=0;
        int outIndex=0;

        while(outIndex<arrOut.length){
            if(!stack.isEmpty() && stack.peek()==arrOut[outIndex]){
                stack.pop();
                outIndex++;
            }else{
                stack.push(arrIn[inIndex]);
                inIndex++;
            }
        }
        return stack.isEmpty();
    }
}
