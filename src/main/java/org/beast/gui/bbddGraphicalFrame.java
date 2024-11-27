package org.beast.gui;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class bbddGraphicalFrame extends JFrame {
    public bbddGraphicalFrame() throws SQLException, IOException {
        setBounds(300,300,480,300);
        bbddGraphicalPanel panel=new bbddGraphicalPanel();
        add(panel);
    }
}
