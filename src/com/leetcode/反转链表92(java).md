**题目:**
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

**说明**:
1 ≤ m ≤ n ≤ 链表长度。

**示例**:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

> 来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**解题:**
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
       //定义一个哨兵节点
       ListNode sentry = new ListNode(-1);
       //将哨兵节点作为表头
       sentry.next = head;
       head = sentry;
       //找到反转点
       ListNode pre = head;
       ListNode cur = head.next;
       for( int i = 1; i < m; i++){
           pre = cur;
           cur = cur.next;
       }
       //找的第一段的末尾节点和第二段的末尾节点
       ListNode l1end = pre;
       ListNode l2end = cur;
       //反转第二段链表
        ListNode nxt = cur.next;
       for(int i = m; i <= n; i++){
           cur.next = pre;
           if(i == n)
                break;
           pre = cur;
           cur = nxt;
           nxt = nxt.next;
       }
       //拼接链表
       l1end.next = cur;
       l2end.next = nxt;
       return head.next;
    }
}
```