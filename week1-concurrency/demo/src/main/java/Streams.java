import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        // Imagine this is a reader from a TCP socket
        BufferedReader reader = null;

        // Generate an infinite amount of 'requests'
        //   -- Equal to listening on a port
        Stream.generate(() -> {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        })
                // Filter away all null lines null lines
                .filter(n -> n != null)
                // Do something with the command
                .map(command -> "A OK")
                // Parallelise this!
                .parallel()
                // Print it out. This could be printing it to an OutputStream somewhere....
                .forEach(number -> System.out.println(number));
    }

}
