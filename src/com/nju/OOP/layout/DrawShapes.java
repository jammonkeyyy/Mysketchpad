package com.nju.OOP.layout;
import java.util.Stack;

import com.nju.OOP.shape.Shape;
public class DrawShapes {
    public final static int LINE = 0;
    public final static int CIRCLE = 1;
    public final static int RECT = 2;
    public final static int write = 3;
    public final static  int erase=4;
    public final static  int spray=5;
    public static int type = write;
    public static Stack<Shape> shapes = new Stack<Shape>();
}
