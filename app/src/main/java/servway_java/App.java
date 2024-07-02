package servway_java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App
{
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException
    {
        ServerSocket server = new ServerSocket(8080);
        try
        {
            System.out.println("Server has started on 127.0.0.1:8080.\r\nWaiting for a connection...");
            Socket client = server.accept();
            System.out.println("New client connected.\r\n");

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            Scanner s = new Scanner(in, "UTF-8");
            try
            {
                String data = s.useDelimiter("\\r\\n\\r\\n").next();
                System.out.println("in [" + data + "]\r\n");

                Matcher get = Pattern.compile("^GET").matcher(data);
                if(get.find())
                {
                    Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
                    match.find();

                    byte[] uuid = (match.group(1) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes("UTF-8");
                    byte[] encoded_uuid = MessageDigest.getInstance("SHA-1").digest(uuid);
                    String base64_uuid = Base64.getEncoder().encodeToString(encoded_uuid);

                    String response_txt =
                        "HTTP/1.1 101 Switching Protocols\r\n" +
                        "Connection: Upgrade\r\n" +
                        "Upgrade: websocket\r\n" +
                        "Sec-WebSocket-Accept: " + base64_uuid +
                        "\r\n\r\n";
                    byte[] response = response_txt.getBytes("UTF-8");
                    out.write(response, 0, response.length);
                    System.out.println("out [" + response_txt + "]\r\n");
                }
            }
            finally
            {
                s.close();
            }
        }
        finally
        {
            server.close();
        }
    }
}
