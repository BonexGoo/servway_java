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
    public SWToken ValidToken(WebSocket peer, String token)
    {
        return null;
    }

    public void OnLogin(WebSocket peer, final JSONObject json)
    {
        final var programid = json.getString("programid");
        final var deviceid = json.getString("deviceid");

        var author = "-";
        if(GetProgram(programid).mFastLogin.containsKey(deviceid))
            author = mPrograms.get(programid).mFastLogin.get(deviceid);

        // 새 토큰을 생성
        final var tokencode = SWProgram.CreateTokenCode(deviceid);
        var newtoken = GetToken(tokencode);
        newtoken.mProgramID = programid;
        newtoken.mAuthor = author;
        newtoken.mDeviceID = deviceid;

        // 피어에 토큰등록 및 유효기간갱신
        ValidToken(peer, tokencode);

        // 응답처리1
        var out = new JSONObject();
        out.put("type", "Logined");
        out.put("author", author);
        out.put("token", tokencode);
        peer.send(out.toString());

        System.out.println("send ===> " + out.toString());////////////////////////////////

        // 응답처리2
        if(!author.equals("-"))
        {
            var CurProfile = mPrograms.get(programid).GetProfile(programid, author, true);
            if(CurProfile != null)
            {
                CurProfile.SendPacket(mServer, peer);
                // 혹시 입장상태가 아니었다면 포커싱된 피어들에게 알림
                CurProfile.ValidStatus(mServer, true);
            }
        }
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

    public SWToken GetToken(String key)
    {
        if(!mTokens.containsKey(key))
        {
            try {mTokens.put(key, new SWToken());}
            catch(Exception e) {}
        }
        return mTokens.get(key);
    }

    public SWProgram GetProgram(String key)
    {
        if(!mPrograms.containsKey(key))
        {
            try {mPrograms.put(key, new SWProgram());}
            catch(Exception e) {}
        }
        return mPrograms.get(key);
    }

    ////////////////////////////////////////////////////////////
    // member
    public int mPort = -1;
    public int mServer = -1;
    public int mPacketMutex = -1;
    public Hashtable<Integer, String> mPeerTokens = new Hashtable<>(); // [peerid:33]
    public Hashtable<String, SWToken> mTokens = new Hashtable<>(); // [token:ClInavrmjQ357437]
    public Hashtable<String, SWProgram> mPrograms = new Hashtable<>(); // [programid:ZayPro]
}
