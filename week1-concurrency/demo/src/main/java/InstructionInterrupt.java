/**
 * Example on how count++ is really 3 instructions which can be interrupted by the
 * scheduler.
 */
public class InstructionInterrupt {

    public static void main(String[] args) {
        int[] count = new int[]{0};

        Runnable r = () -> count[0]++;

        for (int i = 0; i < 1000; i++) {
            new Thread(r).start();
        }
        // This should be 1000! But because of race-conditions it could be anything from 0 to 1000.
        System.out.println(count[0]);
    }

}
