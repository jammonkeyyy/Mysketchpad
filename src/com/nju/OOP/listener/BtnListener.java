package com.nju.OOP.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.nju.OOP.Tools.Function;
import com.nju.OOP.layout.DrawShapes;

public class BtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton target = (JButton)e.getSource();
        String actionCommand = target.getActionCommand();
        if(actionCommand.contentEquals("Line")) {
            DrawShapes.type = DrawShapes.LINE;
        }
        if(actionCommand.contentEquals("Rectangle")) {
            DrawShapes.type = DrawShapes.RECT;
        }
        if(actionCommand.contentEquals("Circle")) {
            DrawShapes.type = DrawShapes.CIRCLE;
        }
        if(actionCommand.contentEquals("Write")) {
            DrawShapes.type = DrawShapes.write;
        }
        if(actionCommand.contentEquals("redo")) {
            Function.redo();
        }
        if(actionCommand.contentEquals("undo")) {
            Function.undo();
        }
        if(actionCommand.contentEquals("clear")) {
            Function.clear();
        }
        if(actionCommand.contentEquals("save")) {
            Function.save();
        }
    }


}
