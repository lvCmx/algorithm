package 字符串;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * MKP算法
 */
public class KMP {

    public static void main(String[] args) {
        String str="abaabcaba";
        int index = KMP(str, "cab");
        System.out.println(index);
    }

    public static int KMP(String source,String pattern){
        // 定义next数组的长度
        int[] next=new int[pattern.length()];
        // 组成模式串
        getNext(pattern.toCharArray(),next);
        // 原串的长度
        int sourceLength=source.length();
        int patternLength=pattern.length();
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        while(i<sourceLength && j<patternLength){
            // 如果j==-1,或者当前字符匹配成功src[i]==ptn[j],都让i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                // 匹配失败的时候,i的值不变，j的值往前走
                j = next[j];
            }
        }
        // 模式串完全匹配
        if (j == patternLength)
            return i - j;
        return -1;
    }

    /**
     * next数组第一版
     *
     * 求next数组
     * @param arr
     * @param next
     */
    public static void getNext(char[] arr,int[] next){
        int length=arr.length;
        next[0]=-1; // 固定，就这么写嘛
        int k=-1;
        int j=0;
        while(j<length-1){
            // 此刻，k即next[j-1]，且p[k]表示前缀,p[j]表示后缀
            // 注：k==-1表示未找到k前缀与k后缀相等，首次分析可先忽略
            if(k==-1 || arr[j]==arr[k]){
                ++j;
                ++k;
                next[j]=k;
            }else{
                // p[j]与p[k]失配，则继续递归计算前缀p[next[k]]
                k=next[k];
            }
        }
    }

    /**
     * 改进版的nextval
     */
    public static void getNext2(char[] arr,int[] next){
        int length=arr.length;
        next[0]=-1;
        int k=-1;
        int j=0;
        // 解释一下为什么j是0,length-1，是因为在求的这个数是j+1
        while(j<length-1){
            if(k ==-1 || arr[j]==arr[k]){
                ++j;
                ++k;
                if(arr[j]==arr[k]){
                    // 优化点就是这个：如果arr[j]=arr[k]，则说明再模式串向后退的时候，需要再往后退
                    next[j]=next[k];
                }else{
                    next[j]=k;
                }
            }
        }
    }
}
