package com.antaev.hackerrank.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class EchoServer {
    public static final Charset UTF8 = Charset.forName("UTF-8");

    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService executor;

    public EchoServer(int port, ExecutorService executor) throws IOException {
        if (port < 0) {
            throw new IllegalArgumentException("port must be >= 0: " + port);
        }
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        this.executor = executor;
    }

    public void start() throws IOException {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());
                executor.submit(new EchoHandler(clientSocket));
            }
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            EchoServer server = new EchoServer(8989, executor);
            server.start();
        } finally {
            executor.shutdown();
            executor.shutdownNow();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}

final class EchoHandler implements Runnable {
    private final Socket clientSocket;

    EchoHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            run0();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void run0() throws IOException {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (!Thread.currentThread().isInterrupted()) {
                String line = input.readLine();
                if (line == null) {
                    return;
                }
                System.out.println("Received: " + line);
                output.write(line);
                output.write('\n');
                output.flush();
                if ("END".equals(line)) {
                    return;
                }
            }
        } finally {
            System.out.println("Closing connection " + clientSocket.getInetAddress());
            clientSocket.close();
        }
    }
}

