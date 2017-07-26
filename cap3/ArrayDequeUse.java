import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeUse {

  public static void main(String[] args) {
    // This way will instantiate ArrayDeque<Object>();
    //Queue<Integer> q = new ArrayDeque();
   
    // The diamond operator will get integer from Queue declaration
    Queue<Integer> q = new ArrayDeque<>();
    System.out.println(q.offer(10));
    System.out.println(q.offer(4));
    System.out.println(q.peek());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.peek());
  }

}
