package org.beast.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class bbddGraphicalPanel extends JPanel {
    public bbddGraphicalPanel(){
        setLayout(new BorderLayout());
        resourceFinder=new JComboBox();
        resourceInfo=new JTextArea();
        add(resourceFinder, BorderLayout.NORTH);
        add(resourceInfo,BorderLayout.CENTER);
    }
    public void wireToDataBase(){

        coneccion=null;

        try{
            coneccion= DriverManager.getConnection("jdbc:postgresql://localhost:9292/demo","postgres","12345678");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private JComboBox resourceFinder;
    private JTextArea resourceInfo;
    private Connection coneccion;
}
