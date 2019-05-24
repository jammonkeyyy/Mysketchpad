package com.nju.OOP.shape;

import com.nju.OOP.listener.ColorPanel;
import com.nju.OOP.listener.ThicknessPanel;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class DrawSpray extends Shape{
    public Vector<ScreenPoint> points1 = new Vector<>();
    public DrawSpray(){}
    public DrawSpray(Color color, int Thickness, int x1, int y1, int x2, int y2){
        super(color, Thickness, x1, y1, x2, y2);
    }
    public void DrawShape(Graphics2D g)
    {
        g.setColor(color);
        g.setStroke(new BasicStroke(1));
        int i=0,j=0;
        while(points1.size()>i)
        {
                g.drawLine(points1.elementAt(i).x, points1.elementAt(i).y, points1.elementAt(j).x, points1.elementAt(j).y);
                i=i+2;
                j=j+2;
        }
        g.setColor(ColorPanel.color);
        g.setStroke(new BasicStroke(ThicknessPanel.thick));
    }
    public void addpoint(int x1,int y1,int x2,int y2) {
        points1.add(new ScreenPoint(x1, y1));
        points1.add(new ScreenPoint(x2, y2));
    }
    public void setcolorthick(Color color0,int thick) {
        Thickness=thick;
        color=color0;
    }
}
