package com.servway;

public class ZDAsset extends ZDRecordable
{
    public ZDAsset()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public boolean Locking(int server, String author)
    {
        return false;
    }

    ////////////////////////////////////////////////////////////
    // override
    @Override
    public void SaveFile(String programid)
    {
    }

    @Override
    protected String BuildPacket()
    {
        return "";
    }

    @Override
    protected String DataDir(String programid)
    {
        return "";
    }

    ////////////////////////////////////////////////////////////
    // member
    public boolean mLocked = false;
    public ZDRoute mRoute = new ZDRoute();
}
