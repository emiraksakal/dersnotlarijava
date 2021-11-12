package l2;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data=data;
        next= null;
    }
    Node() {} // n5 için yaptık

    public static void main(String[] args) {
        Node n1 = new Node(34);
        Node n2 = new Node(5);
        Node n3 = new Node(-5);
        Node n4 = new Node(10);
        Node n5 = new Node();
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(n1.toString());
    }

    public String toString() {
        return "the value of node: " +this.data;
    }
}
