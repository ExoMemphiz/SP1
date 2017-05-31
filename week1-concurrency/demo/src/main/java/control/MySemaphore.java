package control;

import java.util.concurrent.Semaphore;

/**
 * Created by jens on 01.02.17.
 */
public class MySemaphore {

    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(2);
        s.acquire();
        s.acquire();

        // s.acquire()  -- This will deadlock

        s.release();
        s.release();
    }

}
