package 线性表;

/**
 * 给定排序的链表，删除重复元素，只保留重 复元素第一次出现的结点。
 *  给定:2→3→3→5→7→8→8→8→9→9→10
 *  返回:2→3→5→7→8→9→10
 */
public class 排序链表中去重 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 8,8});
        removal(listNode);
        ListNodeUtil.print(listNode);
    }

    // 去除重复
    public static void removal(ListNode node){
        if(null==node){
            return;
        }
        ListNode root=node;
        while(null!=root && null!=root.next){
            if(null!=root.next){
                if(root.key==root.next.key){
                    if(null!=root.next.next){
                        root.next=root.next.next;
                    }else{
                        root.next=null;
                    }
                }else{
                    root=root.next;
                }
            }
        }
    }
}
