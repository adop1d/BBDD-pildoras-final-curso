package org.beast;

import org.beast.gui.bbddGraphicalFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        bbddGraphicalFrame vista=new bbddGraphicalFrame();
        vista.setVisible(true);
        vista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        System.out.println("Just adding a few things");
    }
}