package 数组;

/**
 * 使用折半查找的前提是：数组必须是有序的
 */
public class 折半查找 {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,9};
        boolean result=find(arr,3);
        System.out.println(result);
    }

    private static boolean find(int[] arr, int k) {
        if(arr==null){
            return false;
        }
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==k){
                return true;
            }else if(arr[mid]<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}
