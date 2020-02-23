感谢b站 up 主 [noicfanker](https://space.bilibili.com/352916555)
清晰的讲解，视频链接在[这里](https://www.bilibili.com/video/av66440465?from=search&seid=9224069888132292054)
**题目:**
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

**示例 :**

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

**说明 :**

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

>来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 ```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //new 一个哨兵节点并作为头节点
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        head = sentry;
        //定义 pre,start,end,nxt
        ListNode pre = head;
        ListNode start = head.next;
        //修改
        ListNode end = head.next;
        ListNode nxt = head.next ;
        //每 k 个节点为一组分别反转链表
        while(nxt != null){
            for(int i = 1; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null)
                break;
            nxt = end.next;
            end.next = null;
            end = start;
            start= reverse(start);
        //拼接链表
            pre.next = start;
            end.next = nxt;
            pre = end;
            start = nxt;
            end = start;
        }

        return head.next;

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode nxt = null;
        while(head != null){
            nxt = head.next; 
            head.next = pre;
            pre = head;
            head = nxt;
                 
        }
        return pre;
    }
}
```
