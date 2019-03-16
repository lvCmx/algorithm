package 字符串;

/**
 * 两个序列X和Y的公共子序列中，长度最长的那个，定义为X和Y的最长公共子序列
 * 例如：字符串13455与245576，最长公共子序列为:455
 *      字符串acdfg与adfc的最长公共子序列为adf
 *
 * 思路：
 *            LCS(Xm-1,Yn-1)+Xm (当Xm=Yn)
 * LCS(Xm,Yn)=
              max{LCS(Xm-1,Yn),LCS(Xm,Yn-1)}    当Xm=/=Yn
    显然，属于动态规划的问题
    使用二维数组C[m,n]
 */
public class LCS最长公共子序列 {

    public static void main(String[] args) {
        String str1="TCGGATCGACTT";
        String str2="AGCCTACGTA";
        String result=LCS(str1,str2);
        System.out.println(result);
    }

    private static String LCS(String str1, String str2) {
        if(str1==null || str2==null){
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int size1=str1.length();
        int size2=str2.length();
        //用于图中的数据
        int[][] chess=new int[size1][size2];
        for(int i=1;i<size1;i++){
            for(int j=1;j<size2;j++){
                if(chars1[i]==chars2[j]){
                    chess[i][j]=chess[i-1][j-1]+1;
                }else{
                    chess[i][j]=Math.max(chess[i][j-1],chess[i-1][j]);
                }
            }
        }

        char[] result=new char[chess[size1-1][size2-1]];
        int index=result.length-1;
        size1--;
        size2--;
        while(size1!=0 && size2!=0){
            if(chars1[size1]==chars2[size2]){
                result[index--]=chars1[size1];
                size1--;
                size2--;
            }else{
                if(chess[size1][size2-1]>chess[size1-1][size2]){
                    size2--;
                }else{
                    size1--;
                }
            }
        }
        return new String(result);
    }
}
