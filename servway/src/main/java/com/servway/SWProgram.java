package com.servway;

import java.util.Hashtable;

public class SWProgram
{
    public SWProgram()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public SWProfile GetProfile(String programid, String author, boolean entering)
    {
        return null;
    }

    public SWAsset GetAsset(String programid, final SWRoute route)
    {
        return null;
    }

    public SWRange ValidRange(String programid, final SWRoute route)
    {
        return mRanges.get(route.mPath);
    }

    public SWRoute ParseRoute(String programid, String route)
    {
        return ParseRoute(programid, route, -1);
    }

    public SWRoute ParseRoute(String programid, String route, int writable_server)
    {
        return new SWRoute();
    }

    ////////////////////////////////////////////////////////////
    // static
    public static String CreateTokenCode(String deviceid)
    {
        return "";
    }

    public static String CreateTimeTag()
    {
        return "";
    }

    ////////////////////////////////////////////////////////////
    // member
    public Hashtable<String, String> mFastLogin = new Hashtable<>(); // [deviceid:ClInavrmjQ] → author
    public Hashtable<String, SWProfile> mProfiles = new Hashtable<>(); // [author:BonexGoo] → profile
    public Hashtable<String, SWAsset> mAssets = new Hashtable<>(); // [path:board/post/33] → asset
    private Hashtable<String, SWRange> mRanges = new Hashtable<>(); // [path:board/post/33] → peers
}
