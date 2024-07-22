package com.servway;

//import java.io.File;
//import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
//import java.nio.file.Paths;
//import java.security.KeyStore;
import java.util.Collections;
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLParameters;
//import javax.net.ssl.TrustManagerFactory;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
//import org.java_websocket.server.SSLParametersWebSocketServerFactory;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

public class Main extends WebSocketServer
{
    public Main(int port) throws UnknownHostException
    {
        super(new InetSocketAddress(port));
    }

    public Main(InetSocketAddress address)
    {
        super(address);
    }

    public Main(int port, Draft_6455 draft)
    {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    ////////////////////////////////////////////////////////////
    // override
    @Override
    public void onStart()
    {
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        //System.out.println("onOpen - OK");
        //conn.send("onOpen - OK");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote)
    {
        //System.out.println("onClose - OK");
        //conn.send("onClose - OK");
    }

    @Override
    public void onError(WebSocket conn, Exception ex)
    {
        //System.out.println("onError - OK");
        //conn.send("onError - OK");
    }

    @Override
    public void onMessage(WebSocket conn, String message)
    {
        JSONObject in = new JSONObject(message);
        switch(in.getString("type"))
        {
        case "Login": mServWay.OnLogin(conn, in); break;
        case "OnLoginUpdate": mServWay.OnLoginUpdate(conn, in); break;
        case "OnLogout": mServWay.OnLogout(conn, in); break;
        case "OnFocusProfile": mServWay.OnFocusProfile(conn, in); break;
        case "OnUnfocusProfile": mServWay.OnUnfocusProfile(conn, in); break;
        case "OnLockAsset": mServWay.OnLockAsset(conn, in); break;
        case "OnUnlockAsset": mServWay.OnUnlockAsset(conn, in); break;
        case "OnFocusRange": mServWay.OnFocusRange(conn, in); break;
        case "OnUnfocusRange": mServWay.OnUnfocusRange(conn, in); break;
        }
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message)
    {
        //System.out.println("onMessage2 - OK");
        //conn.send("onMessage2 - OK");
    }

    ////////////////////////////////////////////////////////////
    // main
    public static void main(String[] args) throws InterruptedException, Exception
    {
        /*String STORETYPE = "JKS";
        String KEYSTORE = Paths.get("servway", "src", "test", "java", "server.jks").toString();
        String STOREPASSWORD = "server1234";
        String KEYPASSWORD = "server1234";

        KeyStore ks = KeyStore.getInstance(STORETYPE);
        File kf = new File(KEYSTORE);
        ks.load(new FileInputStream(kf), STOREPASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, KEYPASSWORD.toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        SSLContext sslContext = null;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        SSLParameters sslParams = new SSLParameters();
        sslParams.setNeedClientAuth(true);*/
        Main sw = new Main(8981);
        //sw.setWebSocketFactory(new SSLParametersWebSocketServerFactory(sslContext, sslParams));
        sw.start();
    }

    ////////////////////////////////////////////////////////////
    // member
    ServWay mServWay = new ServWay();
}
