package example.client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public Client(String address, int port){
        //initialize socket and io streams
        DataOutputStream dout = null;
        Scanner scanner = null;
        Socket sock = null;
        try {
            sock = new Socket (address, port);
            System.out.println("Connected to server...");
            System.out.println("Input \"done\" to kill connection...");
            //get input from user to send as message
            scanner = new Scanner(System.in);
            //open output stream on socket
            dout = new DataOutputStream(sock.getOutputStream());
        }
        catch(UnknownHostException h){
            System.out.println(h);
        }
        catch(IOException e){
            System.out.println(e);
        }
        String message = "";
        //read until "done" is input
        while (!message.equals("done")){
            message = scanner.nextLine();
            try {
                dout.writeUTF(message);
            }
            catch(IOException ex){
                System.out.println(ex);
            }
        }
        System.out.println("Connection terminated...");
        try {
            dout.close();
            sock.close();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
    public static void main(String args[]){
        Client client = new Client("localhost", 6666);
    }
}