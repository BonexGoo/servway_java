package com.servway;

import java.util.Hashtable;

public class ZDProgram
{
    public ZDProgram()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public ZDProfile GetProfile(String programid, String author, boolean entering)
    {
        return null;
    }

    public ZDAsset GetAsset(String programid, final ZDRoute route)
    {
        return null;
    }

    public ZDRange ValidRange(String programid, final ZDRoute route)
    {
        return mRanges.get(route.mPath);
    }

    public ZDRoute ParseRoute(String programid, String route)
    {
        return ParseRoute(programid, route, -1);
    }

    public ZDRoute ParseRoute(String programid, String route, int writable_server)
    {
        return new ZDRoute();
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
    public Hashtable<String, ZDProfile> mProfiles = new Hashtable<>(); // [author:BonexGoo] → profile
    public Hashtable<String, ZDAsset> mAssets = new Hashtable<>(); // [path:board/post/33] → asset
    private Hashtable<String, ZDRange> mRanges = new Hashtable<>(); // [path:board/post/33] → peers
}
