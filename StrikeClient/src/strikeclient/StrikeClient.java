/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeclient;

import java.io.IOException;

/**
 *
 * @author elkha
 */
public class StrikeClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Client c = new Client("localhost", 3500);
        c.gioca();
    }
    
}
