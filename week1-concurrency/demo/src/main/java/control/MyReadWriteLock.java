package control;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jens on 01.02.17.
 */
public class MyReadWriteLock {

    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int x = 0;

    public static void main(String[] args) {
        Runnable r = () -> {
            Lock writeLock = lock.writeLock();
            try {
                Thread.sleep(200);
                x += 10;
            } catch (InterruptedException e) {
            } finally {
                writeLock.unlock();
            }
        };

        new Thread(r).start();
        new Thread(r).start();

        new Thread(() -> {
            while (true) {
                System.out.println(x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
