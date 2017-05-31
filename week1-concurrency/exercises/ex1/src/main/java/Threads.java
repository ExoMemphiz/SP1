import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h2>Task 1</h2>
 * <p>
 * Write three methods:
 * <ol>
 * <li>Compute and print the sum of all numbers from 1 to 1 billion.</li>
 * <li>
 * Print the numbers from 1 to 5. Pause for 2 seconds between each print.
 * </li>
 * <li>
 * Print all numbers from 10 and up to {@link Integer#MAX_VALUE}. Pause for 3
 * seconds between each print.
 * </li>
 * </ol>
 * Create three threads that run each of the above methods. Start them all
 * simultaneously from your main method. Stop / kill the thread running the
 * third method after waiting 10 seconds.
 * </p>
 */
public class Threads {

    /**
     * Starts three threads that execute three methods simultaneously.
     *
     * @param args Input arguments to the main method. Unused.
     */
    public static void main(String[] args) {
        final Threads threads = new Threads();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                threads.computeTask1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    threads.printNumbers();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    threads.printToMax();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Stopping printToMax forcefully.");
                t3.stop();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        stopper.start();
        
    }
    
    public void computeTask1() {
        long result = 0;
        for (int i = 1; i <= 1000000000; i++) {
            result += i;
        }
        System.out.println("[computeTask1]: " + result);
    }
    
    public void printNumbers() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[printNumbers]: " + i);
            Thread.sleep(2000);
        }
    }
    
    public void printToMax() throws InterruptedException {
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            System.out.println("[printToMax]: " + i);
            Thread.sleep(3000);
        }
    }
    
}