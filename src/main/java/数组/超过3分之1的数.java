package 数组;

import java.util.Arrays;

/**
 * 超过3/1的数，一个数组中只可能最多出现两个或者1个
 */
public class 超过3分之1的数 {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,5,2,2,3,3,2,3};
        int[] result=findModel(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findModel(int[] arr) {
        if(arr==null || arr.length<=0){
            return null;
        }
        int[] result=new int[2];
        int n=0,m=0;
        int cn=0,cm=0;
        for(int i=0;i<arr.length;i++){
            if(cn==0){
                n=arr[i];
                cn=1;
            }else if(cm==0){
                m=arr[i];
                cm=1;
            }else if(arr[i]==n){
                cn++;
            }else if(arr[i]==m){
                cm++;
            }else{
                cn--;
                cm--;
            }
        }
        //判断m与n是否都满足
        cm=cn=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==m){
                cm++;
            }else if(arr[i]==n){
                cn++;
            }
        }
        if(cm>arr.length/3){
            result[0]=m;
        }
        if(cn>arr.length/3){
            result[1]=n;
        }
        return result;
    }
}
