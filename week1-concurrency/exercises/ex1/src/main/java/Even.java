import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h2>Task 2</h2>
 * <p>
 * This class should only return even numbers. It will be called from many
 * different threads, so it has to be thread-safe. In other words it has to be
 * able to avoid race-conditions if several threads calls it at once.
 * </p>
 * <p>
 * Your task is to implement the {@link #next()} method to return 0 as the
 * first number, 2 as the second, 4 and so on.
 * </p>
 */
public class Even implements Iterator<Long> {

    // The counter containing the number the iterator has reached.
    private long counter;

    /**
     * This has 2^64 numbers. That's a lot!
     *
     * @return Always true.
     */
    @Override
    public boolean hasNext() {
        // Don't change this: we assume we always have another number
        return true;
    }

    /**
     * @return The next even number in the iterator.
     */
    @Override
    public synchronized Long next() {
        return 2 * counter++;
    }

    /**
     * Test your solution here by calling {@link #next()} from different threads.
     *
     * @param args Input arguments to the main method. Unused.
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Even even = new Even();
                for (int i = 0; i < 5; i++) {
                    if (even.hasNext()) {
                        System.out.println("Thread #1: " + even.next());
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                Even even = new Even();
                for (int i = 0; i < 5; i++) {
                    if (even.hasNext()) {
                        System.out.println("Thread #2: " + even.next());
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                Even even = new Even();
                for (int i = 0; i < 5; i++) {
                    if (even.hasNext()) {
                        System.out.println("Thread #3: " + even.next());
                    }
                }
            }
        });
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
    }

}
