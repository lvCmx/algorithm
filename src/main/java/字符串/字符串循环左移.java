package 字符串;

/**
 * 对于一个字符串，将前k位移到字符串的尾部
 * 例如：
 *  abcdef   k=2
 *  result:cdefab
 *
 *  思路：将k之前字符反转，将k之后字符反转，然后将整个字符反转
 */
public class 字符串循环左移 {
    public static void main(String[] args) {
        String str="abcdef";
        int k=2;
        String result=reverseKFirst(str,k);
        System.out.println(result);
    }

    private static String reverseKFirst(String str, int k) {
        if(str==null || str.length()<k){
            return null;
        }
        char[] arr = str.toCharArray();
        reverse(0,k-1,arr);
        reverse(k,str.length()-1,arr);
        reverse(0,str.length()-1,arr);
        return new String(arr);
    }

    private static void reverse(int i, int k, char[] arr) {
        while(i<k){
            char temp=arr[i];
            arr[i++]=arr[k];
            arr[k--]=temp;
        }
    }
}
