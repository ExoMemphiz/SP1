package network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("localhost", 8080));
        System.out.println(server.getLocalPort());

        // Get connection
        Socket menjaConnection = server.accept();
        // Listen to what Menja says
        InputStream input = menjaConnection.getInputStream();
        System.out.println(input.read());

        // Reply to Menja
        OutputStream output = menjaConnection.getOutputStream();
        output.write(80);
        output.flush();

        // Print done
        System.out.println("Yay I'm done!");
    }

}
