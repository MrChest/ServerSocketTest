import java.io.*;
import java.net.*;
/**
 * Created by chestnov.v on 30.01.2017.
 */
public class ServerSocketTest {
    public static void main(String[] args) throws IOException
    {
        try
        {
            ServerSocket sSocket = new ServerSocket(8890);

            Socket incoming = sSocket.accept();

            BufferedInputStream reader = new BufferedInputStream(incoming.getInputStream());
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("c:\\rep.txt"));

            byte[] byteArray = new byte[8192];
            int in;
            while ((in = reader.read(byteArray))!=-1)
            {
                writer.write(byteArray,0, in);
            }

            reader.close();
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("error" + e.getMessage());
        }
    }

}
