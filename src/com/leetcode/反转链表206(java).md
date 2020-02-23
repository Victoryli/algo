**题目:**
反转一个单链表。

**示例:**

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
> 来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 迭代版反转链表
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode Next = head.next; //保存下一节点
            head.next = pre;//当前节点指向前一节点
            pre = head;//当前节点变为前一节点
            head = Next;//下一节点为当前节点
        }
        return pre;
    }
}
```
迭代版较为简单，具体思路为：将当前节点为 null 作为 while 的终止条件，循环中的逻辑为：
**1.** 保存当前节点的下一节点
**2.** 当前节点指向前一节点
**3.** 当前节点变为前一节点
**4.** 下一节点变为当前节点

### 递归版反转链表
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
    public ListNode reverseList(ListNode head) {
       return reverse(null,head);
       
    }

    public ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }
}
```

递归的3个条件：
* 大问题可以分为子问题
* 每个子问题规模相同，逻辑一致，计算方法相同
* 有终止条件

在这道题中：
* 大问题为反转链表，可以拆分为的子问题为：先保存当前节点的下一节点，然后将当前节点指向前一节点，当前节点变为前一节点，下一节点变为当前节点
* 每个子问题的计算方法都相同
* 终止条件为，当前节点为 null
