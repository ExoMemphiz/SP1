import fibonacci.FibonacciGui;
import fibonacci.GuiObserver;

/**
 * <h2>Task 4</h2>
 * <p>
 * This task is about making a Fibonacci GUI responsive. This GUI is admittedly not very pretty, but does its job.
 * </p>
 * <p>
 * First create and show the GUI. You can get some inspiration in the {@link FibonacciGui} class.
 * </p>
 * <p>
 * Notice that this class implements a {@link GuiObserver} which can listen for any events coming from the GUI.
 * Exploit this to start the calculation when the {@link #startCalculation(long)} method is called.
 * </p>
 */
public class ResponsiveFibonacciGui implements GuiObserver {

    /**
     * This method starts the FibonacciGui.
     */
    public static void main(String[] args) {
        // Start the gui in the proper Swing way!
        
    }

    /**
     * If you registered this observer correctly, this method is called when the GUI receives a mouse-click. This
     * means that the user would like to start the calculation. And preferably asynchronously!
     *
     * @param length The size of the fibonacci sequence to calculate.
     */
    @Override
    public void startCalculation(long length) {
        // 1: Start the calculation
        // 2: You need to somehow tell the gui that it's done. Use the observer pattern!
    }
}
