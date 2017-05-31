package fibonacci;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A GUI for a simple Fibonacci calculator. You should not have to change anything in this class.
 */
public class FibonacciGui extends JFrame implements FibonacciObserver {

    private final JTextField input = new JTextField("100");
    private final JButton button = new JButton("calculate");
    private final JLabel output = new JLabel("null");
    private final List<GuiObserver> observers = new ArrayList<>();

    public FibonacciGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fibonacci calculator");
        setPreferredSize(new Dimension(500, 300));

        final GridLayout grid = new GridLayout();
        setLayout(grid);

        add(input);
        add(button);
        add(output);

        button.addActionListener((event) -> {
            long length = Long.decode(input.getText());
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            for (GuiObserver observer : observers) {
                observer.startCalculation(length);
            }
        });

        // Show this gui
        setVisible(true);
    }

    /**
     * Adds an observer to the GUI which will be notified when a user clicks a button.
     *
     * @param observer The observer to be notified of any clicks.
     */
    public void addGuiObserver(GuiObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void dataReady(long data) {
        output.setText(Long.toString(data));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * This methods creates the GUI, but the GUI does nothing...
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FibonacciGui());
    }

}
