package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        System.out.println(socket.getLocalPort());

        //socket.bind(new InetSocketAddress("localhost", 8080));
        socket.connect(new InetSocketAddress("localhost", 8080));
        OutputStream output = socket.getOutputStream();
        output.write(42);
        output.flush();

        InputStream input = socket.getInputStream();
        System.out.println(input.read());

        System.out.println(socket.getLocalPort());
    }

}
