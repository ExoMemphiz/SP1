package control;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jens on 01.02.17.
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger x = new AtomicInteger();

        Runnable r = () -> x.addAndGet(3);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(x.get());

    }

}
