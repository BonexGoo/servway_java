package com.servway;

import org.json.JSONObject;

public abstract class SWRecordable extends SWFocusable
{
    public SWRecordable()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public void VersionUp(String programid, int server, int peerid)
    {
    }

    ////////////////////////////////////////////////////////////
    // member
    public String mAuthor = new String(); // BonexGoo
    public String mVersion = new String(); // w1_t20240129T102834Z_a210034020003
    public JSONObject mData = new JSONObject();
}
