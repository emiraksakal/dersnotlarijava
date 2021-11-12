import java.util.ArrayList;
import java.util.HashSet;

public class MyDoubleLinkedList {
    DoubleNode first;
    DoubleNode last;
    int size = 0;

    public static void main(String[] args) {
        MyDoubleLinkedList dlist = new MyDoubleLinkedList();
        dlist.insertFirst(100);
        dlist.insertFirst(200);
        dlist.insertFirst(300);
        dlist.insertFirst(150);
        dlist.print();
        MyDoubleLinkedList dlist2 = new MyDoubleLinkedList();
        dlist2.insertFirst(150);
        dlist2.insertFirst(250);
        dlist2.insertFirst(350);
    }

    public MyDoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    void insertFirst(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (last == null) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    void insertLast(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    int removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        int r = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return r;
    }

    int removeLast() { // you can also return int
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int r = last.data;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return r;
    }

    int remove(DoubleNode n) {
        if (isEmpty() || n == null) {
            throw new java.util.NoSuchElementException();
        }
        if (n == first) {
            return removeFirst();
        } else if (n == last) {
            return removeLast();
        } else {
            DoubleNode back = n.previous;
            DoubleNode front = n.next;
            back.next = front;
            front.previous = back;
            size--;
            return n.data; //n.getElement();
        }

    }

    void insertAfter(int x, DoubleNode prev) {
        if (prev == null) {
            throw new java.util.NoSuchElementException();
        }
        DoubleNode newNode = new DoubleNode(x);

        newNode.next = prev.next;
        newNode.previous = prev;

        prev.next.previous = newNode;
        prev.next = newNode;
    }

    void deleteNode(DoubleNode deleteMe) {
        if (deleteMe == null) {
            throw new java.lang.NullPointerException();
        }
        deleteMe.next.previous = deleteMe.previous;
        deleteMe.previous.next = deleteMe.next;
    }

    public void print() {
        DoubleNode tmp = this.first;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public DoubleNode search(int value) {
        DoubleNode tmp = first;
        while (tmp != null) {
            if (tmp.data == value) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
