package main.java;

import java.util.HashSet;

public class LinkedList {
    Node head;

    // Made public only because some problems require Nodes as parameter
    public static class Node{
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

    /*
    Problem 2.2 Return Kth to Last
    Implement an algorithm to find the kth to last element of a single linked list
     */

    public Integer kthToLast(int k){
        Node p1 = head;
        Node p2 = head;

        // Place p1 k nodes ahead of p2
        for (int i = 0; i < k; i++){
            if (p1 == null) return null;
            p1 = p1.next;
        }

        // Move p1 to the end and p2 to kth to end
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }

    /*
    Problem 2.3 Delete Middle Node
    Implement an algorithm to delete a node in the middle (ie., any node but the first and last node,
    not necessarily the exact middle) of a singly linked list, given only access to that node.
    Example:
    input: the node c from the linked list a -> b -> c -> d -> e -> f
    result: nothing is returned but the new linked list looks like a -> b -> d -> e -> f
     */
    public void deleteMiddleNode(Node n){
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
    }

    /*
    Problem 2.4 Partition
    Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
    greater than or equal to x. (IMPORTANT: The partition element x can appear anywhere in the "right partition";
    it does not need to appear between the left and right partitions.
     */

    public void partition(int x) throws Exception {
        // find partition node
        Node current = head;
        Node partition = null;
        while (current != null){
            if (current.data == x){
                partition = current;
                break;
            }
            current = current.next;
        }

        if (partition == null){
            throw new Exception(x + " cannot be the partition because it is not in the list");
        }
        Node lessThanHead = null;
        Node lessThantail = null;
        Node greaterThanHead = new Node(partition.data);
        Node greaterThanTail = greaterThanHead;
        current = head;
        // Split into < list and >= list
        while (current != null){
            Node temp = new Node(current.data);
            if (current.data < x){
                if (lessThanHead == null){
                    lessThanHead = temp;
                    lessThantail = lessThanHead;
                } else {
                    lessThantail.next = temp;
                    lessThantail = temp;
                }
            } else if (current != partition) {
                greaterThanTail.next = temp;
                greaterThanTail = temp;
            }
            current = current.next;
        }

        if (lessThanHead == null) {
            head = greaterThanHead;
        } else {
            lessThantail.next = greaterThanHead;
            head = lessThanHead;
        }


    }
}
