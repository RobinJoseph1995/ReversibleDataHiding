/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversibledatahidingclient.client;

import com.reversible.Globals;
import com.reversible.HexDecoder;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Santhosh
 */
public class ClientThread {
    private ClientCallback callback;
    private PrintWriter clientPW;
    
    public ClientCallback getCallback() {
        return callback;
    }

    public void setCallback(ClientCallback callback) {
        this.callback = callback;
    }
    
    public void start() {
        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    final Socket client = new Socket(Globals.DATA_HOST,Globals.DATA_PORT);
                    
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    final PrintWriter pw = new PrintWriter(client.getOutputStream());
                    
                    clientPW = pw;
                    
                    String line="";
                    
                    while((line=reader.readLine())!=null) {
                        System.out.println(line);
                        
                        if(line.startsWith("[success]") || line.startsWith("[failed]")) {
                            if(callback!=null) {
                                callback.updateStatus(line);
                            }
                        }
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        clientThread.start();
    }

    public boolean connect(String clientName) {
        if(this.clientPW!=null) {
            this.clientPW.println("[connect]:"+clientName);
            this.clientPW.flush();
            
            return true;
        } 
        
        return false;
    }

    public boolean register(String userName, String password, String emailId) {
        if(this.clientPW!=null) {
            this.clientPW.println("[register]:"+userName+","+password+","+emailId);
            this.clientPW.flush();
            
            return true;
        }
        
        return false;
    }

    public boolean login(String userName, String password) {
        if(this.clientPW!=null) {
            this.clientPW.println("[login]:"+userName+","+password);
            this.clientPW.flush();
            
            return true;
        }
        
        return false;
    }

    public boolean sendImage(BufferedImage image1, String imageFile1, String imageType) {
        
        if(this.clientPW!=null) {
            try {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

                ImageIO.write(image1, "png", byteOut);

                byte[] img = byteOut.toByteArray();

                String hex = HexDecoder.encode(img);

                int div = hex.length()/1024;
                int divi = hex.length()%1024;
                
                this.clientPW.println("[image]:"+imageFile1+","+imageType);
                this.clientPW.flush();
                
                int i=0;
                for(i=0;i<div;i++) {
                    this.clientPW.println(hex.substring(i*1024, i*1024+1024));
                    this.clientPW.flush();
                }
                
                if(divi!=0) {
                    this.clientPW.println(hex.substring(i*1024));
                    this.clientPW.flush();
                }

                this.clientPW.println("---end of hex---");
                this.clientPW.flush();
                
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
}
