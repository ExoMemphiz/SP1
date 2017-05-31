import fibonacci.FibonacciObserver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Task 3</h2>
 * <p>
 * This task is about creating a fibonacci calculator using the Observer pattern.
 * </p>
 * <p>
 * The purpose of this class is to implement a thread that can calculate a fibonacci number
 * asynchronously and whose results can be published via the observer pattern.
 * </p>
 * <p>
 * Your task is to first implement the {@link #fibonacci(long)} function to correctly calculate the fibonacci
 * sequence.
 * </p>
 * <p>
 * Then you should implement the {@link #run()} method of the {@link ObservableFibonacciCalculator} (which
 * is basically a Thread) to execute this calculation. You need to publish your results somehow...
 * </p>
 * <p>
 * To test if everything works, try to run the main method below. I wrote some hints on how to proceed. Good luck!
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Observer_pattern">https://en.wikipedia.org/wiki/Observer_pattern</a>
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">https://en.wikipedia.org/wiki/Fibonacci_number</a>
 */
public class ObservableFibonacciCalculator extends Thread {

    private final long fibonacciLength;

    private final List<FibonacciObserver> observers = new ArrayList<>();

    /**
     * Creates a fibonacci calculator which calculates the {@link #fibonacciLength}'th number of the fibonacci sequence.
     *
     * @param fibonacciLength The length of the fibonacci sequence to calculate.
     */
    public ObservableFibonacciCalculator(long fibonacciLength) {
        this.fibonacciLength = fibonacciLength;
    }

    /**
     * Calculates the fibonacci sequence for the given input number.
     *
     * @param n The number in the fibonacci sequence to calculate.
     * @return Most likely a very very large number.
     */
    private long fibonacci(long n) {
        if (n <= 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Register an observer which will be called when the calculater has finished calculating the
     * fibonacci sequence.
     *
     * @param observer The observer to add to this calculator.
     */
    public void registerFibonacciObserver(FibonacciObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(long data) {
        for (FibonacciObserver o : observers) {
            o.dataReady(data);
        }
    }
    
    /**
     * This method calculates the fibonacci sequence on this calculator and notifies all its observers.
     */
    @Override
    public void run() {
        // 1: Get the result of the fibonacci sequence
        long value = fibonacci(fibonacciLength);
        // 2: Notify all the observers who subscribed to this class
        notifyObservers(value);
    }

    /**
     * Runs the fibonacci calculator and prints the result when it's done.
     */
    public static void main(String[] args) {
        // 1: Register an observer
        FibonacciObserver obs = new FibonacciObserver() {
            @Override
            public void dataReady(long fibonacci) {
                System.out.println("New Data: " + fibonacci);
            }
        };
        // 2: Start the calculation in a thread
        ObservableFibonacciCalculator calc = new ObservableFibonacciCalculator(6);
        calc.registerFibonacciObserver(obs);
        // 3: Wait for a result
        calc.start();
        // 4: Print the result
    }

}
