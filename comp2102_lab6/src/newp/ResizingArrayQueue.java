/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newp;
/**
 *
 * @author Ozay
 */
public class ResizingArrayQueue<Item> {
    private Item[] q; // array of elements
    int N = 0; // number of elements on queue private
    int first; // index of first element of queue
    int last; // index of next available slot

    public ResizingArrayQueue(int size) {
        q = (Item[]) new Object[size];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // Enqueue, put a new data to the last
    public void enqueue(Item data) {
        // double size of array if necessary and recopy to front of array
        if (N == q.length) {
            resize(2 * q.length);   // double size of array if necessary
        }
        q[last++] = data; // add data

        if (last == q.length) {
            last = 0;          // wrap-around
        }
        N++;
    }

    // Dequeue remove the first data
    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item data = q[first];
        q[first] = null;
        N--;
        first++;
        if (first == q.length || q[first] == null) {
            first = 0;           // wrap-around
        }        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return data;
    }


    public String printQueueOrder() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[i] + " ");
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[(first + i) % q.length] + " ");
        }
        return s;
    }

    public void resize(int newSize) {
        if (newSize <= N) {
            throw new IllegalArgumentException("Invalid price: " + newSize);
        }
        System.out.println("newSize = " + newSize);
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp.clone();
        first = 0;
        last = N;
    }

    public static void main(String[] args) {
        ResizingArrayQueue rq = new ResizingArrayQueue(5);
        rq.enqueue(5);
        rq.enqueue(6);
        rq.enqueue(7);
        rq.enqueue(8);
        rq.enqueue(9);
        rq.enqueue(10);
        System.out.println(rq.printQueueOrder());
        System.out.println(rq.toString());


    }


}
