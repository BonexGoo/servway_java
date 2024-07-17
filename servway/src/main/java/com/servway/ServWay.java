package com.servway;

import java.util.Hashtable;

import org.java_websocket.WebSocket;
import org.json.JSONObject;

public class ServWay
{
    public ServWay()
    {
    }

    @Override
    protected void finalize() throws Throwable
    {
    }

    ////////////////////////////////////////////////////////////
    // method
    public SWToken ValidToken(int peerid, String token)
    {
        return null;
    }

    public void SendPacket(int peerid, final JSONObject json)
    {
    }

    public void SendError(int peerid, final JSONObject json, String text)
    {
    }

    public void OnLogin(WebSocket peer, final JSONObject json)
    {
        JSONObject out = new JSONObject();
        out.put("type", "Logined");
        out.put("author", "Man");
        out.put("token", "1234");
        peer.send(out.toString());
    }

    public void OnLoginUpdate(WebSocket peer, final JSONObject json)
    {
    }

    public void OnLogout(WebSocket peer, final JSONObject json)
    {
    }

    public void OnFocusProfile(WebSocket peer, final JSONObject json)
    {
    }

    public void OnUnfocusProfile(WebSocket peer, final JSONObject json)
    {
    }

    public void OnLockAsset(WebSocket peer, final JSONObject json)
    {
    }

    public void OnUnlockAsset(WebSocket peer, final JSONObject json)
    {
    }

    public void OnFocusAsset(WebSocket peer, final JSONObject json)
    {
    }

    public void OnUnfocusAsset(WebSocket peer, final JSONObject json)
    {
    }

    public void OnFocusRange(WebSocket peer, final JSONObject json)
    {
    }

    public void OnUnfocusRange(WebSocket peer, final JSONObject json)
    {
    }

    public SWToken OnFileUploading(WebSocket peer, final JSONObject json)
    {
        return null;
    }

    public void OnFileUploaded(WebSocket peer, final JSONObject json)
    {
    }

    public void OnDownloadFile(WebSocket peer, final JSONObject json)
    {
    }

    public void OnPythonExecute(WebSocket peer, final JSONObject json)
    {
    }

    public void OnPythonDestroy(WebSocket peer, final JSONObject json)
    {
    }

    ////////////////////////////////////////////////////////////
    // member
    public int mPort;
    public int mServer;
    public int mPacketMutex;
    public Hashtable<Integer, String> mPeerTokens; // [peerid:33]
    public Hashtable<String, SWToken> mTokens; // [token:ClInavrmjQ357437]
    public Hashtable<String, SWProgram> mPrograms; // [programid:ZayPro]
}
