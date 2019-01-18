/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reversible.algorithms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Santhosh
 */
public class TransformationAlgortihms {
    
    public static final int BLOCK_SIZE = 4;
    
    
    private static double SD(BufferedImage block) {
        double sd = 0.0d;
        
        int[] pixels = new int[block.getWidth()*block.getHeight()];
        
        block.getWritableTile(0, 0).getDataElements(0, 0, block.getWidth(), block.getHeight(), pixels);
        
        byte[] pixels3 = new byte[pixels.length];
        
        double sum = 0.0d;
        
        for(int i=0;i<pixels.length;i++) {
            int red = new Color(pixels[i]).getRed();
            int green = new Color(pixels[i]).getGreen();
            int blue = new Color(pixels[i]).getBlue();
            
            int avg = (red+green+blue)/3;
            
            byte p = (byte)((int)avg%(int)255);
            
            pixels3[i] = p;
            sum += p;
        }
        
        final double n1 = 1.0d/(double)pixels3.length;
        final double u = n1 * (double)sum;
        
        double[] pixels4 = new double[pixels3.length];
        
        for(int i=0;i<pixels3.length;i++) {
            pixels4[i] = pixels3[i];
        }
        
        sd = Math.sqrt(n1 * Arrays.stream(pixels4).map(pi->Math.abs(Math.pow(pi-u,2))).sum());
        
        return sd;
    }
    
    public static BufferedImage createTranformedImage(BufferedImage source,BufferedImage target) {
        BufferedImage transformed = null;
        
        int M = (source.getWidth()&target.getWidth())/BLOCK_SIZE;
        int N = (source.getHeight()&target.getHeight())/BLOCK_SIZE;
        
        BufferedImage[][] sourceBlocks = new BufferedImage[N][M];
        BufferedImage[][] targetBlocks = new BufferedImage[N][M];
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                BufferedImage blockIJ = new BufferedImage(BLOCK_SIZE,BLOCK_SIZE,BufferedImage.TYPE_INT_RGB);
                
                for(int k=0;k<BLOCK_SIZE;k++) {
                     for(int l=0;l<BLOCK_SIZE;l++) {
                        blockIJ.setRGB(l, k, source.getRGB(j*BLOCK_SIZE+l, i*BLOCK_SIZE+k));
                    }
                }
                
                sourceBlocks[i][j] = blockIJ;
            }
        }
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                BufferedImage blockIJ = new BufferedImage(BLOCK_SIZE,BLOCK_SIZE,target.getType());
                
                for(int k=0;k<BLOCK_SIZE;k++) {
                    for(int l=0;l<BLOCK_SIZE;l++) {
                        blockIJ.setRGB(l, k, target.getRGB(j*BLOCK_SIZE+l, i*BLOCK_SIZE+k));
                    }
                }
                
                targetBlocks[i][j] = blockIJ;
            }
        }
        
        final List<Double[]> sb = Arrays.stream(sourceBlocks).map(bs->{
                final List<Double> bsd = Arrays.stream(bs).map(b->{
                                return SD(b);
                            }).collect(Collectors.toList());
                
                Double[] bsd1 = new Double[bsd.size()];
                
                bsd1 = bsd.toArray(bsd1);
                
                return bsd1;
            }).collect(Collectors.toList());
        
        Double[][] sbsd = new Double[sb.size()][];
        
        sbsd = sb.toArray(sbsd);
        
        final List<Double[]> tb = Arrays.stream(targetBlocks).map(bs->{
                final List<Double> bsd = Arrays.stream(bs).map(b->{
                                                return SD(b);
                                        }).collect(Collectors.toList());
                
                Double[] bsd1 = new Double[bsd.size()];
                
                bsd1 = bsd.toArray(bsd1);
                
                return bsd1;
            }).collect(Collectors.toList());
        
        Double[][] tbsd = new Double[tb.size()][];
        
        tbsd = tb.toArray(tbsd);
       
        return transformed;
    }
    
}
