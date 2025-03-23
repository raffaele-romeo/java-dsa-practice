package linkedlist;

import java.util.List;
import java.util.Stack;

public class ReverseALinkedList {
    public static class ListNode {
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

    public ListNode reverseListWithStack(ListNode head) {
        var stack = new Stack<ListNode>();

        var currentElem = head;
        while(currentElem != null) {
            stack.push(currentElem);

            currentElem = currentElem.next;
        }

        if (!stack.isEmpty()) {
            head = stack.pop();
            var temp = head;

            while (!stack.isEmpty()){
                temp.next = stack.pop();

                temp = temp.next;
            }

            temp.next = null;
        }

        return head;
    }

    public ListNode reverseListInPlace(ListNode head) {
        var current = head;
        ListNode prev = null;
        ListNode next;

        while(current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode reverseListRecursively (ListNode head) {
        if(head == null || head.next == null) {
            return head; // Base case that stops recursion
        }

        ListNode rest = reverseListRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }


}
