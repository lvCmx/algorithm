package 线性表;

/**
 * 题目：
 * 给定两个单向链表，计算两个链表的第一个 公共结点，若没有公共节点，返回空。
 * 1->2->3
 *       |
 *       |->4->5
 *   9->1|
 *
 *
 */
public class 单链公共结点问题 {

    public static void main(String[] args) {
        ListNode nodeM = ListNodeUtil.createListNode(new int[]{2, 3, 5, 6, 1, 3, 7, 8, 9, 0});
        ListNode nodeN = ListNodeUtil.createListNode(new int[]{ 1, 2, 3, 7, 8, 9, 0});

        ListNode node = publicNode(nodeM, nodeN);
        ListNodeUtil.print(node);
    }

    private static ListNode publicNode(ListNode nodeM, ListNode nodeN) {
        if(null== nodeM || null==nodeN){
            return null;
        }
        // 获取m与n的长度
        int sizeM=0;
        int sizeN=0;
        ListNode mHead=nodeM;
        ListNode nHead=nodeN;

        while(null!=mHead || null!=nHead){
            if(null!=mHead){
                mHead=mHead.next;
                sizeM++;
            }
            if(null!=nHead){
                nHead=nHead.next;
                sizeN++;
            }
        }
        // 重新赋值
        mHead=nodeM;
        nHead=nodeN;
        boolean flag=true;  // 默认是nodeM的链表长

        if(sizeM>sizeN){
            ListNode tempNode=mHead;
            mHead=nHead;
            nHead=tempNode;

            int temp=sizeM;
            sizeM=sizeN;
            sizeN=temp;
        }
        int index=sizeN-sizeM;
        while(null!=nHead && index>0){
            nHead=nHead.next;
            index--;
        }

        ListNode node=null;
        while(null!=mHead && null!=nHead){
            if(mHead.key==nHead.key){
                node=new ListNode(mHead.key,null);
                return node;
            }
            mHead=mHead.next;
            nHead=nHead.next;
        }
        return null;
    }
}
