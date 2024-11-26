package org.beast.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class bbddGraphicalPanel extends JPanel {
    public bbddGraphicalPanel(){
        setLayout(new BorderLayout());

        resourceFinder=new JComboBox();
        resourceInfo=new JTextArea();

        add(resourceFinder, BorderLayout.NORTH);
        add(resourceInfo,BorderLayout.CENTER);

        wireToDataBase();
        getTables();
    }
    public void wireToDataBase(){
        coneccion=null;

        try{coneccion=DriverManager.getConnection("jdbc:postgresql://localhost:9292/demo","postgres","12345678");}
        catch (Exception e){System.out.println(e.getMessage());}
    }

    public void getTables(){
        ResultSet myResultSet=null;

        try{
            DatabaseMetaData dataDDBB=coneccion.getMetaData();
            myResultSet=dataDDBB.getTables("demo",null,null,null);

            while(myResultSet.next()){

                resourceFinder.addItem(myResultSet.getString("TABLE NAME"));

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private JComboBox resourceFinder;
    private JTextArea resourceInfo;
    private Connection coneccion;
}
