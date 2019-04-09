import java.util.concurrent.atomic.AtomicInteger;

public class ArraySummer implements Runnable {
    private int [] array;
    private int begin;
    private int end;
    private AtomicInteger result;


    public ArraySummer(int[] array, int begin, int end, AtomicInteger result) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int sum = 0;
        for (int i = begin; i < end; i++) {
            sum += array[i];
        }
       // System.out.println(thread.getName() + " begin: " +  begin + " end: " + end + " result: " + sum);
        result.addAndGet(sum);

    }

}
