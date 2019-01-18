/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversibledatahidingserver.server;

import com.reversible.Globals;
import com.reversible.HexDecoder;
import com.reversibledata.db.DBUtils;
import com.reversibledata.model.Image;
import com.reversibledata.model.Login;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santhosh
 */
public class ServerThread {
    
    private Hashtable<String,Socket> clients = new Hashtable<String,Socket>();
    private Hashtable<String,Login> logins = new Hashtable<String,Login>();
    
    public void start() {
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    System.out.println("Starting Server...");
                    
                    final ServerSocket server = new ServerSocket(Globals.DATA_PORT);

                    System.out.println("Server Started...!");
                    
                    while(true) {
                        System.out.println("Waiting For Client...");
                        final Socket client = server.accept();
                        System.out.println("Client Connected...!");
                        
                        Thread clientThread = new Thread(new Runnable() {
                            private String clientName = null;
                            
                            @Override
                            public void run() {
                                PrintWriter pw = null;
                                try {
                                    final BufferedReader reader = new  BufferedReader(new InputStreamReader(client.getInputStream()));
                                    pw = new PrintWriter(client.getOutputStream());
                                    
                                    String line="";
                                    
                                    while((line=reader.readLine())!=null) {
                                        System.out.println(line);
                                        
                                        if(line.startsWith("[connect]")) {
                                            final String clientName = line.split(":")[1];
                                            clients.put(clientName, client);
                                            
                                            this.clientName = clientName;
                                            
                                            pw.println("[success]");
                                            pw.flush();
                                        } else if(line.startsWith("[register]")) {
                                            final String userName = line.split(":")[1].split(",")[0];
                                            final String password = line.split(":")[1].split(",")[1];
                                            final String emailid = line.split(":")[1].split(",")[2];
                                            DBUtils.connect();
                                            long c = DBUtils.getLogins().stream().filter(l->l.getusername().equals(userName)).count();
                                            
                                            if(c==0) {
                                                Login login = new Login();
                                                
                                                login.setusername(userName);
                                                login.setpassword(password);
                                                login.setemailid(emailid);
                                                
                                                if(DBUtils.addLogin(login)) {
                                                    pw.println("[success]");
                                                    pw.flush();
                                                } else {
                                                    pw.println("[failed]");
                                                    pw.flush();
                                                }
                                            } else {
                                                pw.println("[failed]");
                                                pw.flush();
                                            }
                                            
                                        } else if(line.startsWith("[login]")) {
                                            final String userName = line.split(":")[1].split(",")[0];
                                            final String password = line.split(":")[1].split(",")[1];
                                            
                                            DBUtils.connect();
                                            long c = DBUtils.getLogins().stream().filter(l->l.getusername().equals(userName) && l.getpassword().equals(password)).count();
                                            
                                            if(c!=0) {
                                                Login login = DBUtils.getLogins().stream().filter(l->l.getusername().equals(userName) && l.getpassword().equals(password)).findFirst().get();
                                                logins.put(this.clientName, login);
                                                
                                                pw.println("[success]");
                                                pw.flush();
                                            } else {
                                                pw.println("[failed]");
                                                pw.flush();
                                            }
                                            
                                        } else if(line.startsWith("[image]")) {
                                            final String fileName = line.split(":")[1].split(",")[0];
                                            final String imageType = line.split(":")[1].split(",")[1];
                                            
                                            if(logins.containsKey(this.clientName)) {
                                                Login login = logins.get(this.clientName);
                                                
                                                if(!new File(Globals.DATA_REPOSITORY).exists())
                                                    new File(Globals.DATA_REPOSITORY).mkdirs();
                                                
                                                String hex = "";
                                                
                                                while(!(line=reader.readLine()).equals("---end of hex---"))
                                                    hex += line;
                                                
                                                byte[] content = HexDecoder.decode(hex);
                                                
                                                FileOutputStream fileOut = new FileOutputStream(new File(Globals.DATA_REPOSITORY,fileName));
                                                fileOut.write(content);
                                                fileOut.flush();
                                                
                                                fileOut.close();
                                                
                                                Image image = new Image();
                                                
                                                image.setloginid(login.getloginid());
                                                image.setimagefile(fileName);
                                                image.setimagetype(imageType);
                                                
                                                DBUtils.connect();
                                                if(DBUtils.addImage(image)) {
                                                    pw.println("[success]");
                                                    pw.flush();
                                                } else {
                                                    pw.println("[failed]");
                                                    pw.flush();
                                                }
                                            } else {
                                                pw.println("[failed]");
                                                pw.flush();
                                            }
                                        }
                                    }
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                                } finally {
                                    pw.close();
                                }
                            }
                        });
                        
                        clientThread.start();
                        
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        serverThread.start();
    }

    public void sendTranformedImage(BufferedImage tranformedImage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
