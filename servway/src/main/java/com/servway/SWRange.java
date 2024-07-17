package com.servway;

public class SWRange extends SWFocusable
{
    public SWRange()
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
    public SWRoute mRoute = new SWRoute();
    public int mFirst = 1;
    public int mLast = -1;
}
