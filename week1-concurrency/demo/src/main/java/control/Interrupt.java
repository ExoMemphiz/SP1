package control;

/**
 * Created by jens on 01.02.17.
 */
public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        t.start();
        t.interrupt();
        t.join();
    }

}
