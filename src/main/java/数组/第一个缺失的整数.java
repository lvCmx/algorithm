package 数组;

import java.util.Arrays;

/**
 * 思路：
 *  我们可以将数组的内容复位到它所在的下标中，这样，就可以完成第一个缺失的整数
 */
public class 第一个缺失的整数 {
    public static void main(String[] args) {
        int[] arr={0,4,5,1,2,-3,7,14,8};
        int result=firstMissNumber(arr);
        System.out.println(result);
    }

    private static int firstMissNumber(int[] arr) {
        if(arr==null || arr.length<=0){
            return -1;
        }
        int size=arr.length-1;
        int i=1;
        while(i<=size){
            if(arr[i]==i){
                i++;
                //arr[i]==arr[arr[i]] 这个表示的是当前位置已经有元素了，不能再放这了
            }else if(arr[i]<0 || arr[i]>size || arr[i]==arr[arr[i]]){
                // 对于这种不满足情况的，我们删除
                arr[i]=arr[size];
                size--;
            }else{
                int temp=arr[arr[i]];
                arr[arr[i]]=arr[i];
                arr[i]=temp;
            }
        }
        return i;
    }
}
