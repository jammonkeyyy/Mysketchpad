package com.nju.OOP.Tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.nju.OOP.layout.Paint;

public class Save {
    JFileChooser jFileChooser;
    public static boolean hassave=true;
    public Save() {
        // TODO Auto-generated constructor stub
        Dimension imageSize = Paint.pnlDisplayArea.getSize();
        jFileChooser=new JFileChooser();
        //设置文件路径
        jFileChooser.setCurrentDirectory(new File("./"));
        //设置默认文件名
        jFileChooser.setSelectedFile(new File("未命名.png"));
        //获取点击的是确定or取消
        int returnVal = jFileChooser.showSaveDialog(null);
        BufferedImage image = new BufferedImage(imageSize.width,imageSize.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        Paint.pnlDisplayArea.paint(g);
        g.dispose();
        File fileW =jFileChooser.getSelectedFile();
//        System.out.println(jFileChooser.CANCEL_OPTION);
        if(returnVal == jFileChooser.APPROVE_OPTION & fileW != null) {
            try {
                ImageIO.write(image,"png", fileW);
//    			JOptionPane notice=new JOptionPane ();
                JOptionPane.showMessageDialog(null, "图片已保存！","保存成功",JOptionPane.INFORMATION_MESSAGE);
                hassave=true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
