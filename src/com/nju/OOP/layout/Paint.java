package com.nju.OOP.layout;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.*;

import com.nju.OOP.listener.BtnListener;
import com.nju.OOP.listener.ColorPanel;
import com.nju.OOP.listener.ThicknessPanel;
import com.nju.OOP.listener.PaintPanel;

public class Paint extends JFrame{
    JPanel pnlCommandArea = new JPanel(new FlowLayout());
    public static PaintPanel pnlDisplayArea = new PaintPanel();//画板
    private JMenuBar mb1 =new JMenuBar();
    private ColorPanel gcolor =new ColorPanel();//颜色panel
    public static ThicknessPanel thickpanel = new ThicknessPanel();//粗细panel
    ShapeButton sbtn = new ShapeButton();//图形选择panel

    JButton undobtn = new JButton(new ImageIcon("mysketchpad/img/undo.PNG"));
    JButton redobtn = new JButton(new ImageIcon("mysketchpad/img/redo.PNG"));
    JButton clearbtn = new JButton(new ImageIcon("mysketchpad/img/clear.PNG"));
    JButton savebtn = new JButton(new ImageIcon("mysketchpad/img/save.PNG"));

    private JButton[] buttonArray = new JButton[]{undobtn,redobtn,clearbtn,savebtn};
    private JToolBar toolbar = new JToolBar();

    public Paint() {
        pnlCommandArea.setLayout(new FlowLayout());
        BtnListener btns = new BtnListener();
        JFrame jf = new JFrame("IPaint");
        JPanel jp = new JPanel();

        /******/
        JPanel jp1 = new JPanel();
        for(int i=0;i<buttonArray.length;i++)
        {
            toolbar.add(buttonArray[i]);

            buttonArray[i].addActionListener(btns);

        }
        buttonArray[0].setActionCommand("undo");
        //为按钮设置工具提示信息，当把鼠标放在其上时显示提示信息
        buttonArray[0].setToolTipText("undo");
        buttonArray[1].setActionCommand("redo");
        buttonArray[1].setToolTipText("redo");
        buttonArray[2].setActionCommand("clear");
        buttonArray[2].setToolTipText("clear");
        buttonArray[3].setActionCommand("save");
        buttonArray[3].setToolTipText("save");
        /******/
        jp.setBackground(Color.WHITE);//白色背景
        /******/
        jp.setLayout(new BorderLayout());
        jp.add(toolbar,BorderLayout.NORTH);
        jp1.add(gcolor);
        jp1.add(thickpanel);
        jp1.add(sbtn);
        jp.add(jp1);
        /******/
        jf.add(jp,BorderLayout.NORTH);
        jf.add(pnlDisplayArea);
        jf.setSize(800, 700);//画图板大小800*800
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
