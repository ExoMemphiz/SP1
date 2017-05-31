import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example of atomic operations. The volatile keyword is good to
 * know but deprecated. Please use the Atomic classes.
 */
public class Atomic {

    static volatile int n = 0;

    public static void main(String[] args) {
        // Violate volatile constraint
        Runnable r = () -> {

        };
        for (int x = 0; x < 100; x++) {
            new Thread(r).start();
        }
        System.out.println(n);

        // AtomicInteger example
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();

        // AtomicBoolean example
        AtomicBoolean b = new AtomicBoolean();
        b.getAndSet(true);
    }

}
