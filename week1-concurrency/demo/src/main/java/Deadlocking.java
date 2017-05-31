/**
 * Example of a deadlock by time.
 */
public class Deadlocking {

    public synchronized static void locking() {
        while (true) {
            // Wait forever
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> locking());
        Thread t2 = new Thread(() -> locking());
        t1.start();
        t2.start();
        t2.join();
    }

}
