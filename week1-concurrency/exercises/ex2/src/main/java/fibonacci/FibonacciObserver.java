package fibonacci;

/**
 * An interface which receives data when a fibonacci calculation finished.
 */
@FunctionalInterface
public interface FibonacciObserver {

    /**
     * Called when the data from the calculation is available.
     *
     * @param fibonacci The fibonacci number returned from the calculation.
     */
    void dataReady(long fibonacci);

}
