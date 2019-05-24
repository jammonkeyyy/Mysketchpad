package com.nju.OOP.listener;

import com.nju.OOP.layout.DrawShapes;
import com.nju.OOP.shape.*;
import com.nju.OOP.shape.Shape;


import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class PaintPanel  extends JPanel implements MouseMotionListener, MouseListener {

    private Point Begin = null;//起始点
    private Point End = null;//终止点
    private boolean dottedTag = true;
    private Color color;//颜色
    public static int thick = 1;
    public static int w = 0;//宽度
    public static int h = 0;//高度
    DrawDot dot;
    DrawSpray spray;

    public PaintPanel() {

        setPreferredSize(new Dimension(600, 600));//画板大小
        Border border = new LineBorder(Color.BLACK);//画板边框为黑色
        setBorder(border);
        setBackground(Color.white);//白色背景
        Begin = new ScreenPoint(0, 0);
        End = new ScreenPoint(0, 0);
        dot = new DrawDot();
        spray=new DrawSpray();
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        color = ColorPanel.color;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        w = Math.abs(End.x - Begin.x);
        h = Math.abs(End.y - Begin.y);
        Point min = new Point(0, 0);
        min.x = Math.min(End.x, Begin.x);
        min.y = Math.min(End.y, Begin.y);

        for ( Shape shape : DrawShapes.shapes) {
            g2.setStroke(new BasicStroke());
            shape.DrawShape(g2);
        }
        if (dottedTag) {
            Stroke dash = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
                    new float[] { 5, 5, }, 0f);
            g2.setStroke(dash);
            if (DrawShapes.type== DrawShapes.RECT) {
                g2.drawRect(min.x, min.y, w, h);
            } else if (DrawShapes.type == DrawShapes.LINE) {
                g2.drawLine(Begin.x, Begin.y, End.x, End.y);
            } else if (DrawShapes.type == DrawShapes.CIRCLE) {
                g2.drawOval(min.x, min.y, w, h);
            }else if(DrawShapes.type==DrawShapes.erase){
               // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                dot.DrawShape(g2);
            }else if(DrawShapes.type==DrawShapes.spray){
                spray.DrawShape(g2);
            }else {
                dot.DrawShape(g2);
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        End = e.getPoint();
        if (DrawShapes.type == DrawShapes.write) {
            dot.addpoint(Begin.x, Begin.y, End.x, End.y);
            Begin = End;
        } else if (DrawShapes.type == DrawShapes.erase) {
            dot.addpoint(Begin.x, Begin.y, End.x, End.y);
            Begin = End;
        } else if (DrawShapes.type == DrawShapes.spray) {
            int temp=thick;
         //   System.out.println(thick);
            for (int k = 0; k < 13; k++) {
                Random r = new Random();
                int a = r.nextInt(10+temp*3);
                int b = r.nextInt(10+temp*3);
                spray.points1.add(new ScreenPoint(End.x + a, End.y + b));
                spray.points1.add(new ScreenPoint(End.x + a, End.y + b));
                Begin = End;
            }
        }repaint();
    }
    /*
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     * 更新图形起始位置，以鼠标点击处为起点，此时起点和终点一致
     * 当随手写的时候，更新画笔颜色和粗细
     */
    public void mousePressed(MouseEvent e) {
        dottedTag = true;
        Begin = e.getPoint();
        End = Begin;
        if (DrawShapes.type == DrawShapes.write) {
            dot = new DrawDot();
            color = ColorPanel.color;
            dot.setcolorthick(color, thick);
        }else if(DrawShapes.type==DrawShapes.erase) {
            dot=new DrawDot();
            color=Color.WHITE;
            dot.setcolorthick(color,thick);
        }else if(DrawShapes.type==DrawShapes.spray) {
            spray=new DrawSpray();
            color = ColorPanel.color;
            spray.setcolorthick(color, thick);
        }
    }
    /*
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     * 鼠标释放后，将所画图形入栈
     */
    public void mouseReleased(MouseEvent e) {
        dottedTag = false;
        if (DrawShapes.type == DrawShapes.RECT) {
            DrawShapes.shapes.add(new DrawRect(color, thick, Begin.x, Begin.y, End.x, End.y));
        } else if (DrawShapes.type == DrawShapes.LINE) {
            DrawShapes.shapes.add(new DrawLine(color, thick, Begin.x, Begin.y, End.x, End.y));
        } else if (DrawShapes.type == DrawShapes.CIRCLE) {
            DrawShapes.shapes.add(new DrawCircle(color, thick, Begin.x, Begin.y, End.x, End.y));
        } else if (DrawShapes.type == DrawShapes.write) {
            DrawShapes.shapes.add(dot);
        }else if(DrawShapes.type==DrawShapes.erase){
            DrawShapes.shapes.add(dot);
        }else if(DrawShapes.type==DrawShapes.spray){
            DrawShapes.shapes.add(spray);
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent mouseEvent) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent mouseEvent) {
        // TODO Auto-generated method stub

    }
}