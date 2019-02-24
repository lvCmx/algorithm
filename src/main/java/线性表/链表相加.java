package 线性表;

/**
 * 题目：
 * 给定两个链表，分别表示两个非负整数。它 们的数字逆序存储在链表中，且每个结点只 存储一个数字，计算两个数的和，并且返回 和的链表头指针。
 * 如:输入:2→4→3、5→6→4，输出:7→0→8
 */
public class 链表相加 {

    public static void main(String[] args) {
        //创建两个链表
        ListNode one = crateListNode(new int[]{9, 9, 9});
        ListNode two =  crateListNode(new int[]{1, 2, 3});
        ListNode listNode = addListNode(one, two);
        print(listNode);
    }

    //链表相加
    public static ListNode addListNode(ListNode one,ListNode two){

        ListNode result=new ListNode(-1,null);
        ListNode root=result;
        // 进位
        int carry=0;
        while(null!=one && null!=two){
            int add=one.key+two.key+carry;
            if(add>9){
                // 有进位
                add=add%10;
                carry=1;
            }else{
                //没有进位
                carry=0;
            }
            result.next=new ListNode(add,null);
            result=result.next;

            one=one.next;
            two=two.next;
        }

        // 可能存在两个链表的长度不相等的时候
        while(null!=one){
            // 这里进行重复的判断，主要是为了防止最后一位会有进位
            int add=one.key+carry;
            if(add>9){
                add=add%10;
                carry=1;
            }else{
                carry=0;
            }
            result.next=new ListNode(one.key,null);
            result=result.next;
            one=one.next;
        }

        //可能存在两个链表的长度不相等的时候
        while(null!=two){
            int add=two.key+carry;
            if(add>9){
                add=add%10;
                carry=1;
            }else{
                carry=0;
            }
            result.next=new ListNode(two.key,null);
            result=result.next;
            two=two.next;
        }
        // 加到最后还有进住
        if(carry>0){
            result.next=new ListNode(carry,null);
        }
        return root.next;
    }

    //循环输出链表
    public static void print(ListNode node){
        while(null!=node){
            System.out.println(node.key);
            node=node.next;
        }
    }

    // 生成一个链表，用于测试
    public static ListNode crateListNode(int [] arr){
        if(null!=arr && arr.length>0){
            ListNode result=new ListNode(-1,null);
            ListNode root=result;
            for(int i=0;i<arr.length;i++){
                result.next=new ListNode(arr[i],null);
                result=result.next;
            }
            return root.next;
        }
        return null;
    }

}

class ListNode{
    int key;
    ListNode next;
    ListNode(int key,ListNode next){
        this.key=key;
        this.next=next;
    }
}
