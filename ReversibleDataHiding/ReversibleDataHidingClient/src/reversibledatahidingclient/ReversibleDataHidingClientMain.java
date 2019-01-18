/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversibledatahidingclient;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.reversible.ConsoleRedirect;
import com.reversible.Globals;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import reversibledatahidingclient.client.ClientCallback;
import reversibledatahidingclient.client.ClientThread;

/**
 *
 * @author Santhosh
 */
public class ReversibleDataHidingClientMain extends javax.swing.JFrame {

    /**
     * Creates new form ReversibleDataHidingClientMain
     */
    public ReversibleDataHidingClientMain() {
        initComponents();
        
        ConsoleRedirect redirect = new ConsoleRedirect(this.jTextPaneConsole, this.jProgressBarProgress, System.out);
        System.setOut(redirect);
        System.setErr(redirect);
        
        System.out.println("!!Welcome To Reversible Data Hiding Client!!");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jInternalFrameConsole = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneConsole = new javax.swing.JTextPane();
        jProgressBarProgress = new javax.swing.JProgressBar();
        jInternalFrameEncrypt = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jButtonImage1 = new javax.swing.JButton();
        jButtonImage2 = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabelImage1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelImage2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItemStartClient = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEncrypt = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemRegister = new javax.swing.JMenuItem();
        jMenuItemLogin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(51, 51, 255));
        desktopPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jInternalFrameConsole.setClosable(true);
        jInternalFrameConsole.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrameConsole.setIconifiable(true);
        jInternalFrameConsole.setMaximizable(true);
        jInternalFrameConsole.setResizable(true);
        jInternalFrameConsole.setTitle("Console Output");
        jInternalFrameConsole.setToolTipText("");
        jInternalFrameConsole.setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTextPaneConsole.setBackground(new java.awt.Color(0, 51, 0));
        jTextPaneConsole.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSOLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 18), new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEtchedBorder())); // NOI18N
        jTextPaneConsole.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jTextPaneConsole.setForeground(new java.awt.Color(102, 204, 0));
        jScrollPane1.setViewportView(jTextPaneConsole);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jInternalFrameConsole.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jProgressBarProgress.setPreferredSize(new java.awt.Dimension(146, 22));
        jInternalFrameConsole.getContentPane().add(jProgressBarProgress, java.awt.BorderLayout.PAGE_START);

        desktopPane.add(jInternalFrameConsole);
        jInternalFrameConsole.setBounds(100, 70, 630, 280);

        jInternalFrameEncrypt.setClosable(true);
        jInternalFrameEncrypt.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrameEncrypt.setIconifiable(true);
        jInternalFrameEncrypt.setMaximizable(true);
        jInternalFrameEncrypt.setResizable(true);
        jInternalFrameEncrypt.setTitle("ENCRYPT");
        jInternalFrameEncrypt.setVisible(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ENCRYPT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 18), new java.awt.Color(102, 153, 255))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(350);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 5, true));

        jButtonImage1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButtonImage1.setText("IMAGE1");
        jButtonImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImage1ActionPerformed(evt);
            }
        });

        jButtonImage2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButtonImage2.setText("IMAGE2");
        jButtonImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImage2ActionPerformed(evt);
            }
        });

        jButtonSend.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButtonSend.setText("SEND");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(136, 136, 136))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButtonImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jSplitPane2.setDividerLocation(150);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane2.setViewportView(jLabelImage1);

        jSplitPane2.setLeftComponent(jScrollPane2);

        jScrollPane3.setViewportView(jLabelImage2);

        jSplitPane2.setRightComponent(jScrollPane3);

        jSplitPane1.setRightComponent(jSplitPane2);

        jPanel2.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jInternalFrameEncrypt.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        desktopPane.add(jInternalFrameEncrypt);
        jInternalFrameEncrypt.setBounds(100, 360, 640, 340);

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Reversible Data");

        jMenuItemStartClient.setText("Start Client...");
        jMenuItemStartClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStartClientActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItemStartClient);
        fileMenu.add(jSeparator1);

        jMenuItemEncrypt.setText("Encrypt...");
        jMenuItemEncrypt.setEnabled(false);
        jMenuItemEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEncryptActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItemEncrypt);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("User");

        jMenuItemRegister.setText("Register...");
        jMenuItemRegister.setEnabled(false);
        jMenuItemRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegisterActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRegister);

        jMenuItemLogin.setText("Login...");
        jMenuItemLogin.setEnabled(false);
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemLogin);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private ClientThread clientThread = null;
    
    private void jMenuItemStartClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStartClientActionPerformed
        
        if(this.clientThread==null) {
            final String clientName = JOptionPane.showInputDialog("Enter Client Name : ");
            
            this.clientThread = new ClientThread();
            
            this.clientThread.setCallback(new ClientCallback() {
                @Override
                public void updateStatus(String line) {
                    Globals.lastStatus = line;
                }
            });
            
            this.clientThread.start();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ReversibleDataHidingClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Globals.lastStatus = null;
            
            if(this.clientThread.connect(clientName)) {
                System.out.println("Connection Request Send...!");
                
                while(Globals.lastStatus==null)
                    ;
                
                if(Globals.lastStatus.equals("[success]")) {
                    System.out.println("Client Connected...!");
                    
                    this.jMenuItemRegister.setEnabled(true);
                    this.jMenuItemLogin.setEnabled(true);
                    
                    this.jMenuItemStartClient.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Client Connection Error!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Client Connection Error!");
            }
        }
        
        
    }//GEN-LAST:event_jMenuItemStartClientActionPerformed

    private void jMenuItemRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegisterActionPerformed
        
        final RegisterDialog dialog = new RegisterDialog(this, true);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(new Point(d.width/2-dialog.getWidth()/2, d.height/2-dialog.getHeight()/2));
        dialog.setVisible(true);
        
        final String userName = dialog.getUserName();
        final String password = dialog.getPassword();
        final String emailId = dialog.getEmailId();
        
        Globals.lastStatus = null;
        
        if(this.clientThread.register(userName,password,emailId)) {
            System.out.println("Register Request Send...!");
            
            while(Globals.lastStatus==null)
                ;
                        
            if(Globals.lastStatus.equals("[success]")) {
                System.out.println("Register Successfull!");
            } else {
                System.out.println("Register Unsuccessfull!");
            }
        }
        
        
    }//GEN-LAST:event_jMenuItemRegisterActionPerformed

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        
        final LoginDialog dialog = new LoginDialog(this, true);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(new Point(d.width/2-dialog.getWidth()/2, d.height/2-dialog.getHeight()/2));
        dialog.setVisible(true);
        
        final String userName = dialog.getUserName();
        final String password = dialog.getPassword();
        
        if(this.clientThread!=null) {
            Globals.lastStatus = null;
            
            if(this.clientThread.login(userName,password)) {
                System.out.println("Login Request Send..!");
                
                while(Globals.lastStatus==null)
                    ;
                
                if(Globals.lastStatus.equals("[success]")) {
                    System.out.println("Login Successfull!");
                    
                    this.jMenuItemEncrypt.setEnabled(true);
                } else {
                    System.out.println("Login Unsuccessfull!");
                }
            }
        }
        
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jMenuItemEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEncryptActionPerformed
        
        this.jInternalFrameEncrypt.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemEncryptActionPerformed

    private String imageFile1 = "";
    private String imageFile2 = "";
    
    private void jButtonImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImage1ActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                this.jLabelImage1.setIcon(new ImageIcon(ImageIO.read(selectedFile)));
                this.imageFile1 = selectedFile.getName();
            } catch (IOException ex) {
                Logger.getLogger(ReversibleDataHidingClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonImage1ActionPerformed

    private void jButtonImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImage2ActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try {
                this.jLabelImage2.setIcon(new ImageIcon(ImageIO.read(selectedFile)));
                this.imageFile2 = selectedFile.getName();
            } catch (IOException ex) {
                Logger.getLogger(ReversibleDataHidingClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }//GEN-LAST:event_jButtonImage2ActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        
        if(this.clientThread!=null) {
            if(this.jLabelImage1.getIcon()==null || this.jLabelImage2.getIcon()==null) {
                JOptionPane.showMessageDialog(this, "Please Select Both Images!", "Selection Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            BufferedImage image1 = (BufferedImage) ((ImageIcon)this.jLabelImage1.getIcon()).getImage();
            BufferedImage image2 = (BufferedImage) ((ImageIcon)this.jLabelImage2.getIcon()).getImage();
            
            Globals.lastStatus = null;
            
            System.out.println("Image1 Sending..!");            
            
            if(this.clientThread.sendImage(image1,this.imageFile1,"image1")) {
                System.out.println("Image1 Request Send..!");
                
                while(Globals.lastStatus==null)
                    ;
                
                if(Globals.lastStatus.equals("[success]")) {
                    System.out.println("Image1 Send!");
                    System.out.println("Image2 Sending..!");            
                    
                    Globals.lastStatus = null;
                    
                    if(this.clientThread.sendImage(image2,this.imageFile2,"image2")) {
                    
                        while(Globals.lastStatus==null)
                            ;
                
                        if(Globals.lastStatus.equals("[success]")) {
                            System.out.println("Image2 Send!");
                            
                            JOptionPane.showMessageDialog(this, "Both Images Send!!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Both Images Send Error!!");
                        }
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Both Images Send Error!!");
                }
            }
        }
        
        
        
    }//GEN-LAST:event_jButtonSendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReversibleDataHidingClientMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReversibleDataHidingClientMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButtonImage1;
    private javax.swing.JButton jButtonImage2;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JInternalFrame jInternalFrameConsole;
    private javax.swing.JInternalFrame jInternalFrameEncrypt;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItemEncrypt;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenuItem jMenuItemRegister;
    private javax.swing.JMenuItem jMenuItemStartClient;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBarProgress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextPane jTextPaneConsole;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}