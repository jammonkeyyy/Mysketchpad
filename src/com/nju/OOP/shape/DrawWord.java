package com.nju.OOP.shape;

import java.awt.*;

public class DrawWord extends Shape {
    private String s;
    public int x;
    public int y;
    public DrawWord(){};

    @Override
    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        Font font=new Font("宋体",Font.BOLD,20);
        g.setFont(font);
        if(s!=null){
            g.drawString(s,x,y);
        }
    }
    public void setS(String s){this.s=s;}

}
