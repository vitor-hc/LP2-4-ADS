/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Vitor Hugo
 */
public class Server implements Runnable {

    /**
     * @param args the command line arguments
     */
    private volatile boolean exit=false;
    @Override
    public void run(){
        while(!exit){
        System.out.println("Server is running......");
        }
        System.out.printf("Server is stopped...");
        
        // TODO code application logic here
    }
    public void stop(){
    exit=true;
    }
    
}
