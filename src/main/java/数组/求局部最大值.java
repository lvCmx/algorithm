package 数组;

public class 求局部最大值 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,9,6,4,3,2};
        int result=localMaxNum(arr);
        System.out.println(result);
    }

    private static int localMaxNum(int[] arr) {
        if(arr==null || arr.length<=0){
            return -1;
        }
        int left=0;
        int right=arr.length-1;
        int mid;
        while(left<right){
            mid=(left+right)/2;
            if(arr[mid]>arr[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return arr[left];
    }
}
