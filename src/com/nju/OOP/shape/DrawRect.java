package com.nju.OOP.shape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.nju.OOP.listener.ColorPanel;
import com.nju.OOP.listener.ThicknessPanel;
public class DrawRect extends Shape {
    public DrawRect(Color color,int Thickness,int x1,int y1,int x2,int y2) {
        super(color,Thickness,x1,y1,x2,y2);
    }

    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(Thickness));
        g.drawRect(startPoint.x, startPoint.y, w, h);
       // g.setColor(ColorPanel.color);
      //  g.setStroke(new BasicStroke(ThicknessPanel.thick));
    }

}
