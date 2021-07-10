import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    static DataOutputStream sServer;
    public static void main(String[] args)
    {
        List ejList = new ArrayList<String>();
        ejList.add("William");
        ejList.add("Julian");
        ejList.add("Castañeda");
        ejList.add("Ruiz");
        int port=4000, posLista;
        String mensajeServidor;

        try{
            ServerSocket serverSocket = new ServerSocket(port);

            Socket clientSocket = serverSocket.accept();

            sServer = new DataOutputStream(clientSocket.getOutputStream());
            sServer.writeUTF("Petición recibida.");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while((mensajeServidor = entrada.readLine()) != null) {

                System.out.println("El número recibido es: " + mensajeServidor);
                posLista = Integer.parseInt(mensajeServidor);

                if (posLista<0 || posLista>(ejList.size()-1)) {
                    System.out.println("Error : El número ingresado es menor a 0 o el número es mas grande que el tamaño de la lista.");
                }else{
                    System.out.println("En la posición " + posLista + " se encuentra: " + ejList.get(posLista));
                }
            }
            System.out.println("Fin de la conexión");

            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
