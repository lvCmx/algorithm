package 线性表;

import java.util.Stack;

/**
 * 后缀式运算
 * a+(b-c)*d
 * abc-d*+
 *
 * 中缀表达式可以看做是一个表达式的中序输出
 * 后缀式表达式可以看做是一个表达式树的后序输出、
 *
 * 思路：两个栈，一个是操作数栈，一个是操作符栈
 */
public class 逆波兰表达式 {

    public static void main(String[] args) {
        String str="21+3*";
        int result=reversePolishNotation(str);
        System.out.println(result);
    }

    private static int reversePolishNotation(String str) {
        if(str==null || str.length()<=0){
            return -1;
        }
        char[] arrs = str.toCharArray();
        Stack<Integer> stack = new Stack();
        for(int i=0;i<arrs.length;i++){
            // 将数字压入栈
            if(!isOperator(arrs[i])){
                stack.push(Integer.parseInt(arrs[i]+""));
            }else{
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                if(arrs[i]=='+'){
                    stack.push(pop+pop1);
                }else if(arrs[i]=='-'){
                    stack.push(pop-pop1);
                }else if(arrs[i]=='*'){
                    stack.push(pop*pop1);
                }else if(arrs[i]=='/'){
                    stack.push(pop/pop1);
                }
            }
        }
        return stack.peek();
    }
    private static boolean isOperator(char arr) {
        return arr=='+' || arr=='-' || arr=='*' || arr=='/';
    }
}
