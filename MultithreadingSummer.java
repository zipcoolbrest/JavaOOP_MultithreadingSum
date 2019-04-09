import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingSummer {
    private AtomicInteger result;
    private int [] array;
    private Thread [] threads;
    private int numberOfThreads;

    public MultithreadingSummer(int[] array, int numberOfThreads ) {
        this.result = new AtomicInteger(0);
        this.array = array;
        this.numberOfThreads = numberOfThreads;
        threads = new Thread[numberOfThreads];
    }

    private int result(){

        int begin = 0;
        int pLength = array.length / numberOfThreads;

        for (int i = 0; i < threads.length; i++) {
            threads[i] =  new Thread(new ArraySummer(array, begin, begin + pLength, result));
            threads[i].start();
            begin += pLength;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return result.get();
    }

    public int getResult() {
        return result();
    }
}
