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
        // 동일한 피어가 통신중 토큰을 바꾸면
        var curpeertoken = GetPeerToken(peer);
        if(!curpeertoken.equals(token))
        {
            // 이전 토큰이 있을 경우 제거
            if(!curpeertoken.isBlank() && mTokens.containsKey(token))
            {
                mTokens.get(curpeertoken).Destroy();
                mTokens.remove(curpeertoken);
            }
            mPeerTokens.put(peer, token);
        }
        // 유효기간갱신
        if(mTokens.containsKey(token))
        {
            var curtoken = mTokens.get(token);
            curtoken.UpdateExpiry();
            return curtoken;
        }
        return null;
    }

    public void OnLogin(WebSocket peer, final JSONObject json)
    {
        final var programid = json.optString("programid");
        final var deviceid = json.optString("deviceid");
        if(programid.isBlank() || deviceid.isBlank())
        {
            SendError(peer, json, "Packet lacks content");
            return;
        }

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
        peer.send(new byte[] {0});

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
        System.out.println("개발필요 - OnLoginUpdate");
        SendError(peer, json, "개발필요");
    }

    public void OnLogout(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnLogout");
        SendError(peer, json, "개발필요");
    }

    public void OnFocusProfile(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnFocusProfile");
        SendError(peer, json, "개발필요");
    }

    public void OnUnfocusProfile(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnUnfocusProfile");
        SendError(peer, json, "개발필요");
    }

    public void OnLockAsset(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnLockAsset");
        SendError(peer, json, "개발필요");
    }

    public void OnUnlockAsset(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnUnlockAsset");
        SendError(peer, json, "개발필요");
    }

    public void OnFocusAsset(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnFocusAsset");
        SendError(peer, json, "개발필요");
    }

    public void OnUnfocusAsset(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnUnfocusAsset");
        SendError(peer, json, "개발필요");
    }

    public void OnFocusRange(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnFocusRange");
        SendError(peer, json, "개발필요");
    }

    public void OnUnfocusRange(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnUnfocusRange");
        SendError(peer, json, "개발필요");
    }

    public SWToken OnFileUploading(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnFileUploading");
        SendError(peer, json, "개발필요");
        return null;
    }

    public void OnFileUploaded(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnFileUploaded");
        SendError(peer, json, "개발필요");
    }

    public void OnDownloadFile(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnDownloadFile");
        SendError(peer, json, "개발필요");
    }

    public void OnPythonExecute(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnPythonExecute");
        SendError(peer, json, "개발필요");
    }

    public void OnPythonDestroy(WebSocket peer, final JSONObject json)
    {
        System.out.println("개발필요 - OnPythonDestroy");
        SendError(peer, json, "개발필요");
    }

    public String GetPeerToken(WebSocket peer)
    {
        if(!mPeerTokens.containsKey(peer))
            mPeerTokens.put(peer, new String());
        return mPeerTokens.get(peer);
    }

    public SWToken GetToken(String token)
    {
        if(!mTokens.containsKey(token))
            mTokens.put(token, new SWToken());
        return mTokens.get(token);
    }

    public SWProgram GetProgram(String programid)
    {
        if(!mPrograms.containsKey(programid))
            mPrograms.put(programid, new SWProgram());
        return mPrograms.get(programid);
    }

    public void SendError(WebSocket peer, final JSONObject json, String text)
    {
        var out = new JSONObject();
        out.put("type", "Errored");
        out.put("packet", json.getString("type"));
        out.put("text", text);
        peer.send(out.toString());
        peer.send(new byte[] {0});
    }

    ////////////////////////////////////////////////////////////
    // member
    public int mPort = -1;
    public int mServer = -1;
    public int mPacketMutex = -1;
    public Hashtable<WebSocket, String> mPeerTokens = new Hashtable<>(); // [peer:class]
    public Hashtable<String, SWToken> mTokens = new Hashtable<>(); // [token:ClInavrmjQ357437]
    public Hashtable<String, SWProgram> mPrograms = new Hashtable<>(); // [programid:ZayPro]
}
