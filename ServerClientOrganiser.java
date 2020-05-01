package company2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClientOrganiser extends Thread {

    private Socket s;
    private String name;

    public ServerClientOrganiser(Socket s, String name){
        this.s = s;
        this.name = name;
        //run();

    }

    public void run() {
        try {

            // forms input and output streams from and to the client into lines of text that can be read

            BufferedReader inp = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            PrintWriter outp = new PrintWriter(
                    s.getOutputStream(), true);


            while(true) {

                // accept a message, also blocks until it receives something
                String inputLine = inp.readLine();

                System.out.println(name + " has sent this via input stream: " + inputLine);
                // send the message back
                outp.println("Server: " + inputLine);
                System.out.println(name + " has received this via output stream: " + inputLine);
                //sendTo.flush();

                inputLine = inp.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
