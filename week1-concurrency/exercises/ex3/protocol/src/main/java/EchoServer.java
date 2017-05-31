import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server which simply just echoes whatever it receives
 */
public class EchoServer {

    private final String host;
    private final int port;

    public EchoServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Starts running the server.
     *
     * @throws IOException If network or I/O or something goes wrong.
     */
    public void startServer() throws IOException {
        // Create a new unbound socket
        ServerSocket socket = new ServerSocket();
        // Bind to a port number
        socket.bind(new InetSocketAddress(host, port));

        System.out.println("Server listening on port " + port);

        // Wait for a connection
        Socket connection;
        while ((connection = socket.accept()) != null) {
            // Handle the connection in the #handleConnection method below
            handleConnection(connection);
            // Now the connection has been handled and we've sent our reply
            // -- So now the connection can be closed so we can open more
            //    sockets in the future
            connection.close();
        }
    }

    /**
     * Handles a connection from a client by simply echoing back the same thing the client sent.
     *
     * @param connection The Socket connection which is connected to the client.
     * @throws IOException If network or I/O or something goes wrong.
     */
    private void handleConnection(Socket connection) throws IOException {
        OutputStream output = connection.getOutputStream();
        InputStream input = connection.getInputStream();

        // Read whatever comes in
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();

        PrintStream writer = new PrintStream(output);
        
        String reply = "";
        try {
            reply = handleMessage(line);
        } catch (Exception e) {
            reply = e.getMessage();
            writer.println(reply);
            input.close();
            output.close();
        }
        // Print the same line we read to the client
        writer.println(reply);
    }

    private String handleMessage(String message) throws UnsupportedOperationException {
        if (message.contains("UPPER#")) {
            int index = message.indexOf("UPPER#") + "UPPER#".length();
            return message.substring(index).toUpperCase();
        } else if (message.contains("LOWER#")) {
            int index = message.indexOf("LOWER#") + "LOWER#".length();
            return message.substring(index).toLowerCase();
        } else if (message.contains("REVERSE#")) {
            int index = message.indexOf("REVERSE#") + "REVERSE#".length();
            String msg = message.substring(index);
            StringBuilder builder = new StringBuilder();
            for (int i = msg.length() - 1; i >= 0; i--) {
                builder.append(msg.charAt(i));
            }
            return builder.toString();
        } else if (message.contains("TRANSLATE#")) {
            int index = message.indexOf("TRANSLATE#") + "TRANSLATE#".length();
            String msg = message.substring(index);
            if (msg.equals("hund")) {
                return "dog";
            }
        }
        throw new UnsupportedOperationException("Unknown command, closing connection.");
    }
    
    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer("localhost", 8080);

        // This method will block, forever!
        server.startServer();
    }


}
