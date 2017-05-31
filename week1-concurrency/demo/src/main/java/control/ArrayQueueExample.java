package control;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jens on 01.02.17.
 */
public class ArrayQueueExample {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        for (int i = 0; i < 11; i++){
            queue.put("Hammertime");
        }
    }
}
