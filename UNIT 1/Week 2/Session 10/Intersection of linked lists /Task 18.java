public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            // When a reaches the end, start from headB
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            // When b reaches the end, start from headA
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }
}
