package com.servway;

public class SWProfile extends SWRecordable
{
    public SWProfile()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public void ValidStatus(int server, boolean entered)
    {
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
    public boolean mEntered = false;
    public String mPassword = new String();
    public int mWritten = 0;
    public int mLike = 0;
}
