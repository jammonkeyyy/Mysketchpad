package com.nju.OOP.listener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import com.nju.OOP.listener.PaintPanel;
public class ThicknessPanel extends JPanel {


    public static int thick = 1;
    JSlider jSlider;
    JPanel jPanel_data;

    public ThicknessPanel() {
        super(new GridLayout(2, 1));
        setBorder(new TitledBorder("Thickness"));
        setPreferredSize(new Dimension(120, 60));

        jSlider = new JSlider();
        jPanel_data = new JPanel();

        jPanel_data.setLayout(new GridLayout(1, 2));

        jPanel_data.add(jSlider);

        add(jPanel_data);

        jSlider.setMaximum(20);//最大值
        jSlider.setMinimum(thick);
        jSlider.setValue(thick);
        jSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                thick = jSlider.getValue() / 3;//线条粗细数值
                repaint();
                PaintPanel.thick = thick;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setStroke(new BasicStroke(thick));
        graphics2d.setColor(ColorPanel.color);
        graphics2d.drawLine(20, 45, 100, 45);
        graphics2d.setStroke(new BasicStroke());
    }
}
