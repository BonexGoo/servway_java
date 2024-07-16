package com.servway;

public class ZDRange extends ZDFocusable
{
    public ZDRange()
    {
    }

    @Override
    protected void finalize() throws Throwable
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
    public ZDRoute mRoute = new ZDRoute();
    public int mFirst = 1;
    public int mLast = -1;
}
