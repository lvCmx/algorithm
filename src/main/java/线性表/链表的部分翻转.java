package 线性表;

/**
 * 题目：
 * 给定一个链表，翻转该链表从m到n的位置。 要求直接翻转而非申请新空间。
 *  如:给定1→2→3→4→5，m=2，n=4，返回 1→4→3→2→5。
 *  假定给出的参数满足:1≤m≤n≤链表长度。
 */
public class 链表的部分翻转 {
    public static void main(String[] args) {
        // 创建一个链表
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        int m=2,n=4;
        reverse(listNode,m,n);
        ListNodeUtil.print(listNode);

    }

    // 反转链表
    // 大致思想：将要反转的部分取出来，采用头插法
    public static void reverse(ListNode node,int m,int n){
        if(m<0 || n<0 || m>=n || null==node){
            return;
        }

        int index=1;
        ListNode current=node;
        ListNode subListNode=new ListNode(-1,null);
        ListNode temp=null;
        while(null!=current && index<=n){
            if(index>=m){
                // 采用头插法
                temp=new ListNode(current.key,null);
                temp.next=subListNode;
                subListNode=temp;

                current=current.next;
            }else{
                current=current.next;
            }
            index++;
        }
        // subListNode链表中的值替换原有链表[m,n]的值。
        if(null!=subListNode.next){
            current=node;
            index=1;
            while(null!=current && index<=n){
                if(index>=m){
                    current.key=subListNode.key;
                    subListNode=subListNode.next;
                }
                current=current.next;
                index++;
            }
        }
    }
}