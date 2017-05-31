import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example on how to use a Lock.
 */
public class MyLock {

    public static void main(String[] args) {
        // Reentrant lock is just one implementation. Have a look at the Lock interface.
        Lock lock = new ReentrantLock();

        try {
            lock.lock();
            throw new RuntimeException();
        } finally { // Use a finally block to make sure the lock is unlocked!
            lock.unlock();
        }

    }

}
