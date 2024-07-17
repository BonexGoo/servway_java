package com.servway;

import java.nio.ByteBuffer;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;

public class SWToken
{
    public SWToken()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public void UpdateExpiry()
    {
    }

    public boolean HasExpiry(long now)
    {
        return false;
    }

    public void UploadOnce(String path, int total, int offset, int size, ByteBuffer data)
    {
    }

    public boolean UploadFlush(String path)
    {
        return false;
    }

    public boolean DownloadReady(int peerid, String memo, String path, int offset, int size)
    {
        return false;
    }

    public int TryDownloadOnce(JSONObject json)
    {
        return -1; // PeerID
    }

    public void Destroy()
    {
    }

    ////////////////////////////////////////////////////////////
    // inner
    class Download
    {
        public int mPeerID = -1;
        public String mMemo;
        public int mTotal = 0;
        public int mOffset = 0;
        public Queue<ByteBuffer> mBinaries;
    }

    ////////////////////////////////////////////////////////////
    // member
    String mProgramID; // ZayPro
    String mAuthor; // BonexGoo
    String mDeviceID; // ClInavrmjQ
    Hashtable<String, SWRoute> mLockedRoutes; // [lockid:123456] → route
    Hashtable<Integer, Integer> mExecutedProcessIDs; // [runid] → ProcessID
    Queue<Download> mDownloadFiles = new LinkedList<>(); // [path:board/post/33/python/a.py] → FileData
}
