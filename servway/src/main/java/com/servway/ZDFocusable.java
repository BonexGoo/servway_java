package com.servway;

import java.util.ArrayList;

public abstract class ZDFocusable
{
    public ZDFocusable()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public void Bind(int peerid)
    {
    }

    public void Unbind(int peerid)
    {
    }

    public void SendPacket(int server, int peerid)
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
