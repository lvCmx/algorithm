package 线性表;

/**
 * 若题目变成:若发现重复元素，则重复元素
 *  全部删除，代码应该怎么实现呢?
 *  给定:2→3→3→5→7→8→8→8→9→9→10
 *  返回:2→5→7→10
 * 为了防止1->1这种，所以链表创建的时候，创建头节点
 * 连重复的自身也删除
 */
public class 排序链表中去重2 {

    public static void main(String[] args) {
        ListNode pHead = ListNodeUtil.createListNodeHasHead(new int[]{1,1,1,2,2,2, 3, 4, 5, 5, 5, 6, 7,8, 8, 8});
        removal(pHead);
        ListNodeUtil.printNotHasHead(pHead);
    }

    // 去除重复
    public static void removal(ListNode node){
        if(null==node){
            return;
        }
        ListNode root=node;
        ListNode pNext=root.next;
        while(null!=pNext) {
            ListNode ppNext=pNext.next;
            boolean flag=false;
            while(null!=ppNext && (pNext.key==ppNext.key)) {
                root.next= ppNext;
                pNext=ppNext;
                ppNext=pNext.next;
                flag=true;
            }
            if(flag){
                //说明会存在这种情况：2,2,2，上面的代码会把2，2删除，在这里要把最后一个2再删除
                root.next=ppNext;
            }else{
                root=pNext;
            }
            pNext=ppNext;
        }
    }
}
