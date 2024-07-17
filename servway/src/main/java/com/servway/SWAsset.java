package com.servway;

public class SWAsset extends SWRecordable
{
    public SWAsset()
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
    public SWRoute mRoute = new SWRoute();
}
