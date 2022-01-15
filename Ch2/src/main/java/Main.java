package main.java;

import java.util.HashSet;

public class Main {

    public static class LinkedList {

        Node head;
        
        private static class Node{
            Node next = null;
            int data;

            public Node(int d){
                this.data = d;
            }
        }

        public LinkedList(int data){
            this.head = new Node(data);
        }

        public void addToTail(int data){
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = new Node(data);
        }

        public void prettyPrint(){
            Node n = head;
            while (n != null){
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println("null");
        }
        /*
        Problem 2.1 Remove Dups
        Write code to reomve duplicates from an unsorted linked list. FOLLOW UP How would you solve this problem
        if a temporary buffer is not allowed
         */
        
        public void removeDups() {
            HashSet<Integer> dups = new HashSet<>();
            Node current = head;
            Node prev = null;
            while (current != null){
                if (dups.contains(current.data)){
                    prev.next = current.next;
                } else {
                    dups.add(current.data);
                    prev = current;
                }
                current = current.next;
            }
        }

        public void removeDupsNoBuffer(){
            Node current = head;
            Node prev = null;
            while (current != null){
                // Check rest of list for any duplicates
                Node runner = current;
                while (runner.next != null){
                    if (runner.next.data == current.data){
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }

    }

    public static void main(String[] args){
        LinkedList l1 = getLinkedList();
        l1.prettyPrint();
        l1.removeDups();
        l1.prettyPrint();

        LinkedList l2 = getLinkedList();
        l2.prettyPrint();;
        l2.removeDupsNoBuffer();
        l2.prettyPrint();
    }

    private static LinkedList getLinkedList(){
        LinkedList l = new LinkedList(1);
        l.addToTail(2);
        l.addToTail(2);
        l.addToTail(3);
        l.addToTail(4);
        l.addToTail(5);
        l.addToTail(4);
        l.addToTail(2);
        return l;
    }


}
