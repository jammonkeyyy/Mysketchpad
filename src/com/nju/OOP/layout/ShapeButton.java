package com.nju.OOP.layout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.nju.OOP.listener.BtnListener;

public class ShapeButton extends JPanel{

    BtnListener btns = new BtnListener();

    private JButton
            btn1 = new JButton( "矩形"),
            btn2 = new JButton("圆"),
            btn3 = new JButton("线条"),
            btn4 = new JButton("画笔"),
            btn5=new JButton("橡皮"),
            btn6=new JButton("喷枪");

    public ShapeButton() {
        super(new GridLayout(3, 3));
        setPreferredSize(new Dimension(250, 60));
        btn1.addActionListener(btns);
        btn2.addActionListener(btns);
        btn3.addActionListener(btns);
        btn4.addActionListener(btns);
        btn5.addActionListener(btns);
        btn6.addActionListener(btns);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
    }
}
