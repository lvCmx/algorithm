package 字符串;

import java.util.List;

/**
 * 给定一个数组，求出最长递增子序列
 */
public class 数组最长子序列 {

    public static void main(String[] args) {
        int[] arr={1,2,4,3,6,27,29,16,17,19,22};
        getMaxList(arr);
    }

    private static void getMaxList(int[] arr) {
        if(arr==null || arr.length<=0){
            return ;
        }
        int begin=0;
        int maxLeng=0;
        int end=0;
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(i==0 || arr[i-1]<arr[i]){
                index++;
            }else{
                if(maxLeng<index){
                    begin=i;
                    maxLeng=end;
                }
            }
        }
        System.out.println(maxLeng);
    }
}
