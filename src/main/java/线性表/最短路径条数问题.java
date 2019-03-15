package 线性表;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 解题思路：
 * 定义两个数组，step[]来用保存结点步数
 *              pathNum[]用来保存每个节点的路径数
 * 若step[j]==0
 *      step[j]==step[i]+1,pathNum[j]=pathNum[i]
 * 若step[j]==step[i]+1
 *      pathNum[j]+=pathNum[i];
 */
public class 最短路径条数问题 {
    public static void main(String[] args) {
        //定义一个二维数组来表示各个结点之间的关系
        int[][] relation=new int[16][16];
        relation[0][1]=relation[0][4]=1;
        relation[1][5]=relation[1][0]=relation[1][2]=1;
        relation[2][1]=relation[2][6]=relation[2][3]=1;
        relation[3][2]=relation[3][7]=1;
        relation[4][0]=relation[4][5]=1;
        relation[5][1]=relation[5][4]=relation[5][6]=relation[5][9]=1;
        relation[6][2]=relation[6][5]=relation[6][7]=relation[6][10]=1;
        relation[7][3]=relation[7][6]=1;
        relation[8][9]=relation[8][12]=1;
        relation[9][8]=relation[9][13]=relation[9][10]=1;
        relation[10][9]=relation[10][4]=relation[10][11]=1;
        relation[11][10]=relation[11][15]=1;
        relation[12][8]=relation[12][13]=1;
        relation[13][9]=relation[13][14]=relation[13][12]=1;
        relation[14][10]=relation[14][13]=relation[14][15]=1;
        relation[15][11]=relation[15][14]=1;
        int result=calc(relation);
        System.out.println(result);
    }

    private static int calc(int[][] relation) {
        int[] step=new int[16];       // 每个节点第几步可以达到
        int[] stepNum=new int[16];      //到每个节点有几种走法
        stepNum[0]=1;    //第一个节点自己到自己，一种走法
        // 当前搜索的结点
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
        queue.add(0);   //将第一个节点添加到队列中
        int from,i,s;
        while (!queue.isEmpty()){
            from=queue.poll();
            s=step[from]+1;

            // 0是起点，不遍历
            for(i=1;i<16;i++){
                // 连通
                if(relation[from][i]==1){
                    // i尚未可达或发现更快的路(权值不同才可以)
                    if(step[i]==0 || step[i]>s){
                        step[i]=s;
                        stepNum[i]=stepNum[from];
                        queue.add(i);
                    }
                }else if(step[i]==s){
                    stepNum[i]+=stepNum[from];
                }
            }
        }
        return stepNum[15];
    }
}
