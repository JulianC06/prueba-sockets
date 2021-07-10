import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente extends Servidor{

    public static void main(String[] args)
    {
        int port=4000;
        try
        {
            Socket clientSocket = new Socket("localhost",port);

            DataOutputStream sCliente = new DataOutputStream(clientSocket.getOutputStream());

            sServer.writeUTF("Mensaje");
            clientSocket.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
