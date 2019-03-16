package 数组;

public class 数组超过一半的数 {
    public static void main(String[] args) {
        int[] arr={8,8,1,1,1,8,1,1,6,1,8};
        int result=getMore(arr);
        System.out.println(result);
    }

    private static int getMore(int[] arr) {
        if(arr==null || arr.length<=0){
            return -1;
        }
        int count=0;
        int m=arr[0];
        for(int i=0;i<arr.length;i++){
            if(count==0){
                m=arr[i];
                count=1;
            }else if(arr[i]==m){
                count++;
            }else{
                count--;
            }
        }
        return m;
    }
}
