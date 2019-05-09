package com.antaev.hackerrank.transfer;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TransferTreeTest {
    @Test
    public void test() {
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

        assertEquals(0, model.depth(1));
        assertEquals(1, model.parent(1));

        assertEquals(1, model.depth(2));
        assertEquals(1, model.parent(2));

        assertEquals(2, model.depth(4));
        assertEquals(2, model.parent(4));

        assertEquals(2, model.depth(10));
        assertEquals(6, model.parent(10));

        assertEquals(2, model.depth(8));
        assertEquals(3, model.parent(8));
    }
}