package control;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jens on 01.02.17.
 */
public class ThreadPool {

    static final ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> System.out.println("Justin Beaver");

        try {
            service.execute(r);
        } finally {
            service.shutdown();
        }
    }

    public static void sayHello() {
        service.execute(() -> System.out.println("Halo"));
    }

}
