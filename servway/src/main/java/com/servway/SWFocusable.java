package com.servway;

import java.util.ArrayList;

import org.java_websocket.WebSocket;

public abstract class SWFocusable
{
    public SWFocusable()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public void Bind(WebSocket peer)
    {
    }

    public void Unbind(WebSocket peer)
    {
    }

    public void SendPacket(int server, WebSocket peer)
    {
    }

    public void SendPacketAll(int server)
    {
    }

    ////////////////////////////////////////////////////////////
    // override
    protected abstract void SaveFile(String programid);
    protected abstract String BuildPacket();
    protected abstract String DataDir(String programid);

    ////////////////////////////////////////////////////////////
    // static
    public static String MakeProfileDir(String programid, String author)
    {
        return "";
    }

    public static String MakeAssetDir(String programid, String path)
    {
        return "";
    }

    ////////////////////////////////////////////////////////////
    // member
    public ArrayList<Integer> mPeerIDs = new ArrayList<>();
}
