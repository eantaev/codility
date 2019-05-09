package com.antaev.hackerrank.echo;

import java.io.*;
import java.net.Socket;

public final class EchoClient implements Closeable {
    private final Socket socket;
    private final BufferedReader input;
    private final BufferedWriter output;

    public EchoClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void send(String message) throws IOException {
        System.out.println("Sending: " + message);
        output.write(message);
        output.write('\n');
        output.flush();
    }

    public String receive() throws IOException {
        String received = input.readLine();
        System.out.println("Received: " + received);
        return received;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        try (EchoClient client = new EchoClient("localhost", 8989)) {
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while ((line = in.readLine()) != null) {
                client.send(line);
                System.out.println(client.receive());
            }
        }
    }
}
