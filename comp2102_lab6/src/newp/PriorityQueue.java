package newp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ozay
 */
public class PriorityQueue<T> {

    private int size; // size of the stack
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {

        private T item;
        private Node<T> next;
        private int priority;


        public Node(T item) {
            this.item = item;
        }

        public Node(T item, int pri){
            this.item=item;
            this.priority=0;

        }

        public T getItem() {
            return item;
        }

    }

    public PriorityQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T entry,int pri) {
        Node<T> newNode = new Node(entry,pri);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack underflow");
        }
        Node<T> tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;                // return the saved item
    }

    public void printQueue() {
        if (isEmpty()) {
            return;
        }
        Node tmp = first;
        System.out.print("Queue: ");
        while (tmp != null) {
            System.out.print(tmp.item + "<-");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public Node<T> findHighestPri(){
        int highest = first.priority;
        Node<T> highestNode = null;
        Node<T> tmp= first.next;
        while (tmp!=null){
            if (highest<tmp.priority) {
                highest=tmp.priority;
                highestNode=tmp;
            } tmp= tmp.next;
        }return highestNode;
    }

    public void enqueueinOrder(){
       // Node<T> new Node()
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(1,1);
        pq.enqueue(2,2);
        pq.enqueue(3,4);
        pq.enqueue(5,3);
        pq.enqueue(4,10);
        Node highest= pq.findHighestPri();
        System.out.println("node value: "+highest.item+ "with priority "+highest.priority);

    }
}
