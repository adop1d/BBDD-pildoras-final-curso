package org.beast;

import org.beast.gui.bbddGraphicalFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        bbddGraphicalFrame vista=new bbddGraphicalFrame();
        vista.setVisible(true);
        vista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        System.out.println("working on it");
    }
}