
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <h2>Task 2</h2>
 * <p>
 * By using the {@link UrlRetriever} you implemented in the previous exercise, your job is now to run synchronously
 * and asynchronously.
 * </p>
 * <p>
 * First of all find three different {@link java.net.URL}s you can use. Then create three instances of the
 * {@link UrlRetriever} with these URL's.
 * </p>
 * <ol>
 * <li>The first subtask is to execute the three {@link UrlRetriever}s with the {@link UrlRetriever#run()}
 * method. Note that this is <b>not</b> the start method, so the code is run synchronously.</li>
 * <li>The second subtask is to change the execution to use {@link UrlRetriever#start()}. Remember that this
 * starts an asynchronous thread, so you need to wait for them all to finish!</li>
 * </ol>
 * <p>
 * Both methods will print a run-time on the execution. Can you see a difference on how fast it went? Can you
 * explain why you get that result?
 * </p>
 * <p>
 * Try to run the {@link #getAvailableProcessors()} method to see how many processors you have. Perhaps this
 * can explain the result.
 * </p>
 */
public class UrlRetrieverSynchronisation {

    /**
     * Returns the number of processors Java has detected.
     *
     * @return A positive number.
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        long startTime = System.currentTimeMillis();

        // Run your three UrlRetrievers
        
        UrlRetriever u1 = new UrlRetriever("google.com");
        UrlRetriever u2 = new UrlRetriever("exomemphiz.dk");
        UrlRetriever u3 = new UrlRetriever("http://airline-plaul.rhcloud.com/#/home");
        
        u1.start();
        u2.start();
        u3.start();
        
        u1.join();
        u2.join();
        u3.join();
        
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(String.format("The execution took %d milliseconds", endTime));
        startTime = System.currentTimeMillis();
        
        u1.run();
        u2.run();
        u3.run();

        u1.join();
        u2.join();
        u3.join();
        
        endTime = System.currentTimeMillis() - startTime;
        System.out.println(String.format("The execution took %d milliseconds", endTime));
        

        
        
        // First with the #run() method from the UrlRetriever. How long did that take?
        // Second with the #start() method from the UrlRetriever. How long did that take?
        // - Remember to wait for all the threads to finish!
    }

}
