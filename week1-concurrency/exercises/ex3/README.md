
# Java Socket Exercises-1

## 1) TCP Time Server
Write a TCP time server which should listen on a port and an network interface given as
command line arguments.  (Hint: ``.bind()`` method)

Time should be returned in the format: ``Tue Sep 02 16:00:34 UTC 2014``.

Test your server using a telnet client

## 2) TCP time Client
Write you own client, which can connect to your TCP time server and print the time.

## 3) Echo server with extended protocol
The Echo server can be found here: [https://github.com/CphBusCosSem3/week1-concurrency/tree/master/exercises/ex3/protocol](https://github.com/CphBusCosSem3/week1-concurrency/tree/master/exercises/ex3/protocol)

This package contains two classes: An ``EchoClient`` and a ``EchoServer``. The server listens for connections forever,
and when a connection is established, it listens to the input and simply echoes the same back to the client.
The client connects to the server and writes a string. When it writes it waits for a reply, prints it and quits.

Expand the echo server we did together in the class with the following behaviour.

| Message sent from client to server | Reply from server |
| ---- | ---- |
| UPPER#Hello World | HELLO WORLD |
| LOWER#Hello World | hello world |
| REVERSE#abcd | Dcba |
| TRANSLATE#hund | dog |

If the server receives any message that does not fit the patterns given above, it should 
close the connection.

## 4) Extend the Echo Server with the following functionality:
1. The server should be able to handle many clients simultaneously
2. When a client sends a message to the server, the server should echo the 
message to all connected clients
3. Provide the Client with an Observer based design, to let users subscribe 
for events (incoming data).  The solution must use a separate Thread to 
read incoming data in order to avoid blocking problems.
4. Provide the client with a GUI.

Just add a few hardcode words in a map on the server. Return ``#NOT_FOUND`` for a 
word not found.

