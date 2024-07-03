package com.servway;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class Main extends WebSocketServer
{
    public Main(int port) throws UnknownHostException
    {
        super(new InetSocketAddress(port));
    }

    public Main(InetSocketAddress address)
    {
        super(address);
    }

    public Main(int port, Draft_6455 draft)
    {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    @Override
    public void onStart()
    {
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote)
    {
        conn.send("onClose - OK");
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        conn.send("onOpen - OK");
    }

    @Override
    public void onError(WebSocket conn, Exception ex)
    {
        conn.send("onError - OK");
    }

    @Override
    public void onMessage(WebSocket conn, String message)
    {
        conn.send("onMessage1 - OK");
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message)
    {
        conn.send("onMessage2 - OK");
    }

    public static void main(String[] args) throws InterruptedException, Exception
    {
        Main sw = new Main(8981);
        sw.start();
    }
}
