package com.nju.OOP.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.nju.OOP.listener.ColorPanel;
import com.nju.OOP.listener.ThicknessPanel;

import java.awt.*;
import java.util.Vector;


public class DrawTriangle extends Shape {
    public Vector<ScreenPoint> points2 = new Vector<>();
    public DrawTriangle(){};
    public DrawTriangle(Color color, int Thickness, int x1, int y1, int x2, int y2){
        super(color, Thickness, x1, y1, x2, y2);
    }
    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(Thickness));
        int x3=(points2.firstElement().x+points2.lastElement().x)/2;
        int x[]={points2.firstElement().x,points2.lastElement().x,x3};
        int y[]={points2.lastElement().y,points2.lastElement().y,points2.firstElement().y};
        g.drawPolygon(x,y,3);
        g.setColor(ColorPanel.color);
        g.setStroke(new BasicStroke(ThicknessPanel.thick));
    }
    public void addpoint(int x1,int y1,int x2,int y2) {
        points2.add(new ScreenPoint(x1, y1));
        points2.add(new ScreenPoint(x2, y2));
    }
    public void setcolorthick(Color color0,int thick) {
        Thickness=thick;
        color=color0;
    }
}
