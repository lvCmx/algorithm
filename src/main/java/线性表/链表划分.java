package 线性表;

/**
 * 给定一个链表和一个值x，将链表划分成两 部分，使得划分后小于x的结点在前,大于等于x的结点在后。在这两部分中要保持原链表中的出现顺序。
 *  如:给定链表1→4→3→2→5→2和x = 3，返回 1→2→2→4→3→5。
 *
 * 思路也很简单：
 * 就是定义两个指针a,b，分别将小于x放在a后面
 */
public class 链表划分 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNodeHasHead(new int[]{1, 4, 2, 5, 7, 9, 6, 4});
        int pivot=4;
        partition(listNode,pivot);
        ListNodeUtil.printNotHasHead(listNode);
    }

    // 链表的划分
    public static void partition(ListNode node,int pivot){
        if(node==null){
            return;
        }

        ListNode leftHead=new ListNode(-1,null);
        ListNode rightHead=new ListNode(-1,null);

        ListNode left=leftHead;
        ListNode right=rightHead;
        ListNode p=node.next;
        while(null!=p){
            if(p.key<pivot){
                left.next=p;
                left=p;
            }else{
                right.next=p;
                right=p;
            }
            p=p.next;
        }

        //将两个链表合并成一个链表
        left.next=rightHead.next;
        right.next=null;

        node.next=leftHead.next;
    }
}
