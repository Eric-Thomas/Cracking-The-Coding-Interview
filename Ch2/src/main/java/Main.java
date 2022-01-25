package main.java;

public class Main {


    public static void main(String[] args) throws Exception {
//        LinkedList l1 = getLinkedList();
//        l1.prettyPrint();
//        l1.removeDups();
//        l1.prettyPrint();
//
//        LinkedList l1Nobuffer = getLinkedList();
//        l1Nobuffer.prettyPrint();;
//        l1Nobuffer.removeDupsNoBuffer();
//        l1Nobuffer.prettyPrint();
//
//        LinkedList l2 = getLinkedList();
//        System.out.println(l2.kthToLast(1));

//        LinkedList l3 = getLinkedList();
//        l3.prettyPrint();
//        LinkedList.Node current = l3.head;
//        while (current.data != 7){
//            current = current.next;
//        }
//        l3.deleteMiddleNode(current);
//        l3.prettyPrint();

        LinkedList l4 = getLinkedList();
        l4.prettyPrint();
        l4.partition(6);
        l4.prettyPrint();
    }

    private static LinkedList getLinkedList(){
        LinkedList l = new LinkedList(0);
        l.addToTail(9);
        l.addToTail(2);
        l.addToTail(3);
        l.addToTail(6);
        l.addToTail(7);
        l.addToTail(1);
        l.addToTail(15);
        l.addToTail(2);
        l.addToTail(5);
        return l;
    }


}
