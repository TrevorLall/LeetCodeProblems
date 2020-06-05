/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SumTwoLists {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalList = new ListNode(0);
        ListNode p = l1, q = l2, curr = finalList;
        int carry = 0;

        // Loop through lists
        while (p != null || q != null) {
            // check if lists are empty
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // Add p and q current node
            int sum = carry + x + y;
            carry = sum / 10;

            // Create node for new number
            curr.next = new ListNode(sum % 10);

            // Move to next nodes
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return finalList.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);

        l1.next = new ListNode(4);
        l2.next = new ListNode(6);

        l1.next.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode add = addTwoNumbers(l1, l2);
        while (add != null) {
            System.out.print(add.val + "->");
            if (add.next != null)
                add = add.next;
            else
                return;
        }
    }
}
