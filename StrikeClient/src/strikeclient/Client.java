/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elkha
 */
class Client {
    private Socket socket = null; 
    private DataInputStream input = null; 
    private DataOutputStream out = null; 
    private BufferedReader in = null;
    
    public Client(String address, int port) 
    { 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("INIZIO GIOCO [Connessione stabilita con il server]\n"); 
  
            input  = new DataInputStream(System.in); 
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    }
    public void gioca(){
        
        String tentativo = ""; 
        String risposta = "";
        int t = 4;
        
        while (!tentativo.equals("fine") || t!=0) 
        { 
            try
            { 
                do {
                    tentativo = input.readLine();
                    if (tentativo.length() != 4) {
                        System.out.println("Devi inserire quattro numeri"); //aggiungere controlli che siano effettivamente numeri
                    }
                } while (tentativo.length() != 4); 
                out.writeUTF(tentativo);
                risposta = in.readLine();
                System.out.println(risposta);
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
            t--;
            if(t==0){
                System.out.println("GAME OVER");
                try {
                    socket.close();
                    input.close();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        } 
  
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
}

