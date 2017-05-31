/**
 * Basic operations on how to create and start a thread.
 */
public class ThreadBasic {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("Done sleeping");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        System.out.println("Hi");

        new Thread(() -> System.out.println("Hi1")).start();
        new Thread(() -> System.out.println("Hi2")).start();
        new Thread(() -> System.out.println("Hi3")).start();
    }


}
