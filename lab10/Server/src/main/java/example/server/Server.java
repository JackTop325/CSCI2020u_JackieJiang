package example.server;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.*;

public class Server implements Runnable{

    //Initialize input stream and socket
    private DataInputStream inStream = null;
    private Socket sock = null;
    private ServerSocket serve = null;
    public TextArea textBox;

    public Server(int port, TextArea textBox){
        this.textBox = textBox;
        //start server and wait for client
        try {
            serve = new ServerSocket(port);
            System.out.println("Starting Server...");
            System.out.println("Waiting for client connection...");
            sock = serve.accept();
            System.out.println("Connected to Client...");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public void quit() throws IOException {
        sock.close();
        inStream.close();
        System.out.println("Closed connection");
        System.exit(0);
    }

    @Override
    public void run() {
        //Initialize input stream and socket
        DataInputStream inStream = null;
        try {
            inStream = new DataInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //holds message sent by client
        String message = "";
        while (true){
            try{
                message = inStream.readUTF();
                textBox.appendText(message+"\n");
            }
            catch(IOException e) {
                System.out.println(e);
                System.out.println("Closed connection");
                System.exit(0);
            }
        }
    }
}