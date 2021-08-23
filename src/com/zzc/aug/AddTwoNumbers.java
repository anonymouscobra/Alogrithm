package com.zzc.aug;

import org.junit.Test;

/**
 * @author anonymouscobra
 * @create 2021-08-22-21:27
 * @description 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以0开头。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int addOne = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null || l2 != null || addOne != 0){
            int val1 = l1==null ? 0 : l1.val;
            int val2 = l2==null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            addOne = sum / 10;
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

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

    public static String print(ListNode l){
        StringBuilder sb = new StringBuilder();
        while (l != null){
            sb.append(l.val);
            l = l.next;
        }
        return sb.toString();
    }

    @Test
    public void test(){
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode answer = addTwoNumbers(l11,l12);
        System.out.println(print(answer));
        System.out.println("test");
    }

}
