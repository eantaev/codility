package com.antaev.hackerrank.transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class Edge {
    final int node0;
    final int node1;

    Edge(int node0, int node1) {
        this.node0 = node0;
        this.node1 = node1;
    }
}

final class TransferTree {
    // index = NodeId - 1
    private final int[] parent;
    private final int[] depth;

    TransferTree(int numberOfNodes, Iterable<Edge> edges) {
        this.parent = new int[numberOfNodes];
        this.depth = new int[numberOfNodes];

        for (Edge edge : edges) {
            parent[edge.node1 - 1] = edge.node0 - 1;
        }

        depth[0] = 0;
        for (int i = 1; i != parent.length; ++i) {
            int p = parent[i];
            depth[i] = depth[p] + 1;
        }
    }

    int parent(int node) {
        return parent[node - 1] + 1;
    }

    int depth(int node) {
        return depth[node - 1];
    }

    int path(int node0, int node1) {
        int n0 = node0 - 1;
        int n1 = node1 - 1;
        int depth0 = depth[n0];
        int depth1 = depth[n1];
        int length = 0;
        while (depth0 < depth1) {
            n1 = parent[n1];
            --depth1;
            ++length;
        }
        while (depth0 > depth1) {
            n0 = parent[n0];
            --depth0;
            ++length;
        }
        // depth0 == depth1
        while (n0 != n1) {
            n0 = parent[n0];
            n1 = parent[n1];
            length += 2;
        }
        return length + 1;
    }
}

public final class TransferServer {
    private final int port;
    private final ExecutorService executor;
    private final TransferTree model;

    public TransferServer(int port, ExecutorService executor, TransferTree model) {
        this.port = port;
        this.executor = executor;
        this.model = model;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                executor.submit(new TransferHandler(clientSocket));
            }
        } finally {
            System.out.println("Closing server");
        }
    }

    final class TransferHandler implements Runnable {
        private final Socket clientSocket;

        TransferHandler(Socket clientSocket) {
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
                    if (line == null || "END".equals(line)) {
                        return;
                    }
                    String[] split = line.split(",");
                    // todo validate input
                    int node0 = Integer.valueOf(split[0].trim());
                    int node1 = Integer.valueOf(split[1].trim());
                    int threshold = Integer.valueOf(split[2].trim());
                    int path = model.path(node0, node1);
                    String response = threshold < path ? "NO\n" : "YES\n";
                    output.write(response);
                    output.flush();
                }
            } finally {
                clientSocket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TransferTree model = new TransferTree(10,
                Arrays.asList(new Edge(1, 2),
                        new Edge(2, 4),
                        new Edge(2, 5),
                        new Edge(1, 6),
                        new Edge(6, 9),
                        new Edge(6, 10),
                        new Edge(1, 3),
                        new Edge(3, 7),
                        new Edge(3, 8)));

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            TransferServer server = new TransferServer(8990, executor, model);
            server.start();
        } finally {
            executor.shutdown();
            executor.shutdownNow();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
    }
}
