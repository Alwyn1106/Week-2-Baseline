package company2;
import java.lang.*;

// This is a main for the Server Programme
public class ServerMain extends Thread {

    public static void main(String[] args) {
        EchoServer server = new EchoServer(7777);
    }

}