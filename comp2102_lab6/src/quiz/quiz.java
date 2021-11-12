package quiz;
import java.util.Queue;
import java.util.PriorityQueue;
public class quiz {

    public static void main(String[] args) {
        Queue q1 = new PriorityQueue<Integer>();
        Queue q2 = new PriorityQueue<Integer>();

        q1.add(1);
        q1.add(3);
        q1.add(3);
        q1.add(6);

        q2.add(2);
        q2.add(7);
        q2.add(8);
        q2.add(9);
        q2.add(10);

        System.out.println("First queue: ");
        System.out.println(q1.toString());
        System.out.println("\nSecond queue: ");
        System.out.println(q2.toString());

        Queue result = merge(q1, q2);

        System.out.println("\nMerged queue: ");
        System.out.println(result.toString());
    }



    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> mergedQueue = new Queue<Integer>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
          Integer  x = q1.dequeue();
            Integer y = q2.dequeue();
            while (true) {
                if (x<y) {
                    mergedQueue.enqueue(x);
                    if (q1.isEmpty()) {
                        merge.enqueue(y);
                        break;
                    }
                    x = q1.dequeue();
                }else{
                    merge.enqueue(y);
                    if(q2.isEmpty()){
                        merge.enqueue(x);
                        break;
                    }
                    y=q2.dequeue();
                }
            }
        }
        if (q1.size() > 0) {
            while (!q1.isEmpty()) {
                x=q1.dequeue();
                merge.enqueue(x);
            }
        } else if (q2.size() > 0) {
            while (!q2.isEmpty()) {
                y = q2.dequeue();
                merge.enqueue(y);
            }
        }
        return merge;
    }
}
