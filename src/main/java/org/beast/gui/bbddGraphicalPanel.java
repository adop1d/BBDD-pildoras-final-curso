package org.beast.gui;

import javax.swing.*;
import java.awt.*;

public class bbddGraphicalPanel extends JPanel {
    public bbddGraphicalPanel(){
        setLayout(new BorderLayout());
        resourceFinder=new JComboBox();
        resourceInfo=new JTextArea();
        add(resourceFinder, BorderLayout.NORTH);
        add(resourceInfo,BorderLayout.CENTER);

    }
    private JComboBox resourceFinder;
    private JTextArea resourceInfo;
}
