import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h2>Task 1</h2>
 * <p>
 * In this exercise your job is to implement a {@link Thread} which can download data from the web asynchronously so
 * your application does not block.
 * </p>
 * <p>
 * First of all you need to implement a constructor for this {@link UrlRetriever} class,
 * which takes a {@link URL} and stores it in a local variable. So, later when the {@link UrlRetriever} class (which
 * is in fact a {@link Thread}, since it inherits from the {@link Thread} class) is started, it should take that
 * {@link URL} and use the {@link #getBytesFromUrl(URL)} method to extract the actual bytes from the {@link URL}.
 * This can take a while, so that's why it's handy to do in a Thread instead of blocking the entire application.
 * </p>
 * <p>
 * When the thread has completed its execution, the data (as an array of bytes) should be available through the
 * {@link #getData()} method.
 * </p>
 * <p>
 * Try the class out by giving it URL's to text files or images and try to print the length of the array. You're
 * welcome to try to print the binary array, but it (most probably) won't be pretty!
 * </p>
 */
public class UrlRetriever extends Thread {

    private String url;
    private byte[] bytes;

    public UrlRetriever(String url) {
        this.url = url;
    }
    
    
    
    /**
     * Test your solution here!
     */
    public static void main(String[] args) {
        // 1: Create a URL retriever and start it!
        UrlRetriever retrieve = new UrlRetriever("http://airline-plaul.rhcloud.com/#/home");
        // 2: Wait for it to finish
        retrieve.start();
        // 3: Get the data from the getData() method and print the length of it. It should be > 0
        try {
            //System.out.println(retrieve.getData() == null);
            System.out.println(retrieve.getData().toString().length());
            Thread.sleep(5000);
            System.out.println(retrieve.getData().toString().length());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    /**
     * This method should take a URL (which should be stored when constructing the {@link UrlRetriever}) and
     * extracts the bytes from the URL. This method is an implementation of {@link Thread#run()}, so it will
     * be executed in a new Thread once the {@link #start()} method is invoked.
     */
    @Override
    public void run() {
        try {
            bytes = getBytesFromUrl(new URL(url));
        } catch (Exception e) {
            
        }
    }

    /**
     * @return The bytes retrieved from the URL given in the constructor. If this method is called before the
     * thread is done, {@link Optional#empty()} is returned.
     */
    public Optional<Byte[]> getData() throws IllegalStateException {
        if (isAlive()) {
            return Optional.empty();
        }
        return Optional.of(byteToByte(bytes));
    }

    private Byte[] byteToByte(byte[] bytesPrim) {
        Byte[] bytes = new Byte[bytesPrim.length];
        Arrays.setAll(bytes, n -> bytesPrim[n]);
        return bytes;
    }
    
    /**
     * Given a URL this method downloads the resource and extracts the actual bytes as a byte array.
     *
     * @param url The URL to download.
     * @return The data from the URL, extracted to an array of bytes.
     * @throws IOException If the connection could not be made for some reason.
     */
    private static byte[] getBytesFromUrl(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();

        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try (InputStream is = connection.getInputStream()) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = is.read(buffer)) > 0) {
                bis.write(buffer, 0, read);
            }
        }
        return bis.toByteArray();
    }

}
