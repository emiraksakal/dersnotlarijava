package newp;


public class GenericLinkedQueue<T> {

    private int size; // size of the queue
    private Node<Integer> first;
    private Node<Integer> last;

    private static class Node<T> {

        private int item;
        private Node<T> next;

        public Node(int item) {
            this.item = item;
        }

        public int getItem() {
            return item;
        }

    }

    public GenericLinkedQueue() {
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

    public void enqueue(int entry) {
        Node<Integer> newNode = new Node(entry);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack underflow");
        }
        Node<Integer> tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;                // return the saved item
    }

    public Node<Integer> peek(){
        return first;
    }

    public void printQueue(){
        if (isEmpty()){
            return;
        }
        Node<Integer> tmp=first;
        System.out.println("Queue: ");
        while (tmp!=null){
            System.out.print(tmp.item+ "<--");
            tmp=tmp.next;
        }
        System.out.println();

    }

    public int getMax(){
        int max=first.item;
        Node<Integer> tmp= first.next;
        while (tmp!=null){
            if (tmp.item>max){
                max=tmp.item;
            }
            tmp=tmp.next;
        } return max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenericLinkedQueue q = new GenericLinkedQueue<>();
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(6);
        System.out.println(q.peek().item);
        q.printQueue();
        q.enqueue(8);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        System.out.println(q.getMax());
        //PriorityQueue p1 = new PriorityQueue();

    }

}


