package org.beast.gui;

import javax.swing.*;

public class bbddGraphicalFrame extends JFrame {
    public bbddGraphicalFrame(){
        setBounds(300,300,480,300);
        bbddGraphicalPanel panel=new bbddGraphicalPanel();
        add(panel);
    }
}
