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
        if(actionCommand.contentEquals("线条")) {
            DrawShapes.type = DrawShapes.LINE;
        }
        if(actionCommand.contentEquals("矩形")) {
            DrawShapes.type = DrawShapes.RECT;
        }
        if(actionCommand.contentEquals("圆")) {
            DrawShapes.type = DrawShapes.CIRCLE;
        }
        if(actionCommand.contentEquals("画笔")) {
            DrawShapes.type = DrawShapes.write;
        }
        if(actionCommand.contentEquals("橡皮")) {
            DrawShapes.type = DrawShapes.erase;
        }
        if(actionCommand.contentEquals("喷枪")) {
            DrawShapes.type = DrawShapes.spray;
        }
        if(actionCommand.contentEquals("三角")) {
            DrawShapes.type = DrawShapes.triangle;
        }
        if(actionCommand.contentEquals("文字")) {
            DrawShapes.type = DrawShapes.word;
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
