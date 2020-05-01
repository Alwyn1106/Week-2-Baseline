package company2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;


public class EchoServer extends Thread {
    private int port;
    private ServerSocket ss;
    private int ID;
    // This is the constructor for the Server. This assigns the port value passed by the argument and initiates the run function

    public EchoServer(int port) {
        try {
            System.out.println("Waiting for clients...");
            this.port = port;

            // Creates a new Server Socket for the clients to connect to
            ss = new ServerSocket(port);
            ID=1;
            start();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        try
        {
            // listen for client, waits for the client to be found before progressing
            while(true) {
                Socket client = ss.accept();
                System.out.println("Client-" + ID + " connected on " + ss);
                new ServerClientOrganiser(client, "client-" + ID).start();
                ID++;
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
