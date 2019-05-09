package com.antaev.hackerrank;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

public class ByteBufferTest {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Test
    public void byteBufferFlip() {
        ByteBuffer buf = ByteBuffer.allocate(64);
        buf.put("Hello world".getBytes(UTF8));
        buf.flip();
        String str = readString(buf, 0);
        assertEquals("Hello world", str);
    }

    @Test
    public void byteBufferCompact() {
        ByteBuffer buf = ByteBuffer.allocate(64);
        buf.put("Hello world".getBytes(UTF8));
        buf.flip();
        String s0 = readString(buf, 6);
        assertEquals("Hello ", s0);
        buf.compact();
        buf.put("!".getBytes(UTF8));
        buf.flip();
        String s1 = readString(buf, 0);
        assertEquals("world!", s1);
    }

    @Test
    public void readEmptyBufferIsOk() {
        ByteBuffer buf = ByteBuffer.allocate(64);
        assertEquals(0, buf.getInt());
    }

    private static String readString(ByteBuffer buf, int length) {
        int size = length <= 0 ? buf.remaining() : length;
        byte[] bytes = new byte[size];
        buf.get(bytes);
        return new String(bytes, UTF8);
    }
}