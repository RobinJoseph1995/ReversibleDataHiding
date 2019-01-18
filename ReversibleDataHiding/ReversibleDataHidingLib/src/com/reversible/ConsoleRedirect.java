/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reversible;

import java.awt.Color;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author libin
 */
public class ConsoleRedirect extends PrintStream {
    private JTextPane console;
    private JProgressBar progress;
    
    
    private Style timeStampStyle;
    private Style messageStyle;
    
    public ConsoleRedirect(JTextPane console,JProgressBar progress,OutputStream out) {
        super(out);
        this.console = console;
        this.progress = progress;
        
        StyledDocument doc = this.console.getStyledDocument();
        
        this.timeStampStyle = doc.addStyle("timestamp", null);
        this.messageStyle = doc.addStyle("message", null);
        
        StyleConstants.setForeground(this.timeStampStyle, Color.PINK);
        StyleConstants.setUnderline(this.timeStampStyle, true);
        StyleConstants.setFontSize(this.timeStampStyle, 18);
        StyleConstants.setBold(this.timeStampStyle, true);
        
        StyleConstants.setForeground(this.messageStyle, Color.GREEN);
        StyleConstants.setUnderline(this.messageStyle, false);
        StyleConstants.setFontSize(this.messageStyle, 18);
        StyleConstants.setBold(this.messageStyle, false);
        StyleConstants.setFontFamily(messageStyle, "Courier New");
    }

    @Override
    public void println(Object x) {
        final Object x1 = x;
        
        SwingUtilities.invokeLater(()-> {
            try {
                StyledDocument doc = console.getStyledDocument();
                
                doc.insertString(doc.getLength(), ""+new Date().getTime()+":",timeStampStyle);
                doc.insertString(doc.getLength(), " "+x1.toString()+"\r\n", messageStyle);
            } catch (BadLocationException ex) {
                Logger.getLogger(ConsoleRedirect.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void println(String x) {
        final String x1 = x;
        
        if(x1.startsWith(">:")) {
            SwingUtilities.invokeLater(() -> {
                int v = Integer.parseInt(x1.split(":")[1]);
                
                progress.setMinimum(0);
                progress.setMaximum(100);
                progress.setValue(v);
                
                progress.setString(v + "%");
                progress.setStringPainted(true);
                
                progress.invalidate();
                progress.updateUI();
            });
        } else {
            SwingUtilities.invokeLater(()-> {
                try {
                    StyledDocument doc = console.getStyledDocument();

                    doc.insertString(doc.getLength(), ""+new Date().getTime()+":",timeStampStyle);
                    doc.insertString(doc.getLength(), " "+x1+"\r\n", messageStyle);
                } catch (BadLocationException ex) {
                    Logger.getLogger(ConsoleRedirect.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @Override
    public void print(Object obj) {
        final Object obj1 = obj;
        
        SwingUtilities.invokeLater(()-> {
            try {
                StyledDocument doc = console.getStyledDocument();
                
                doc.insertString(doc.getLength(), obj1.toString(), messageStyle);
            } catch (BadLocationException ex) {
                Logger.getLogger(ConsoleRedirect.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void print(String s) {
        final Object s1 = s;
        
        SwingUtilities.invokeLater(()-> {
            try {
                StyledDocument doc = console.getStyledDocument();
                
                doc.insertString(doc.getLength(), s1.toString(), messageStyle);
            } catch (BadLocationException ex) {
                Logger.getLogger(ConsoleRedirect.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    
}
