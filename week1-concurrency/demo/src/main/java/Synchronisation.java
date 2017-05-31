/**
 * Example on method and block synchronization.
 */
public class Synchronisation {

    // Synchronization 1: Methods
    static int x = 0;

    public static synchronized void dangerZone() {
        x++;
    }

    // Synchronization 2: Blocks
    static Object y = new Object();

    public static void dangerZoneBlock() {
        synchronized (y) {
            x++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> dangerZoneBlock()).start();
        }
        Thread.sleep(100);
        System.out.println(x);
    }

}
