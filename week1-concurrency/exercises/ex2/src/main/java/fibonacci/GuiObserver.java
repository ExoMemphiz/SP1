package fibonacci;

/**
 * An interface which listens to a GUI and is being called when a user would like to start calculating a fibonacci
 * sequence.
 */
@FunctionalInterface
public interface GuiObserver {

    /**
     * Called when a user would like to start a fibonacci calculation with the given length.
     *
     * @param length The size of the fibonacci sequence to calculate.
     */
    void startCalculation(long length);

}
