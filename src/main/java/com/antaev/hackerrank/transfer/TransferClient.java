package com.antaev.hackerrank.transfer;

import java.io.*;
import java.net.Socket;

public class TransferClient implements Closeable {
    private final Socket socket;
    private final BufferedReader input;
    private final BufferedWriter output;

    public TransferClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public String receive() throws IOException {
        return input.readLine();
    }

    public void send(String message) throws IOException {
        output.write(message);
        output.write('\n');
        output.flush();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        try (TransferClient client = new TransferClient("localhost", 8990)) {
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while ((line = in.readLine()) != null) {
                client.send(line);
                String response = client.receive();
                System.out.println("Response: " + response);
            }
            client.send("END");
        }
    }
}
