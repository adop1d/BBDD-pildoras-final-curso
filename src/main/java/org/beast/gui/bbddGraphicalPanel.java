package org.beast.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class bbddGraphicalPanel extends JPanel {
    public bbddGraphicalPanel(){
        setLayout(new BorderLayout());
        setBackground(new Color(60,60,60));

        resourceFinder=new JComboBox();
        resourceInfo=new JTextArea();
        resourceInfo.setBackground(new Color(60,60,60));
        resourceInfo.setForeground(new Color(240,240,240));

        wireToDataBase();
        getTables();

        resourceFinder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = (String)resourceFinder.getSelectedItem();
                showInfoText(tableName);
            }
        });
        add(resourceFinder, BorderLayout.NORTH);
        add(resourceInfo,BorderLayout.CENTER);
    }
    public void wireToDataBase(){
        coneccion=null;
        String data[]=new String[3];

        try{entry = new FileReader
                ("src/main/java/config.txt");
            BufferedReader bufferedReader = new BufferedReader(entry);

            for (int i = 0; i <=2 ; i++)
            {data[i]=bufferedReader.readLine();}

            coneccion=DriverManager.getConnection(data[0],data[1],data[2]);

        entry.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(this,"no se ha encontrado la conexión");
        }
        catch (Exception e)
        {System.out.println(e.getMessage());}
    }

    public void getTables(){
        ResultSet myResultSet=null;

        try{
            DatabaseMetaData dataDDBB=coneccion.getMetaData();
            myResultSet=dataDDBB.getTables(null,null,null,null);

            while(myResultSet.next()){
                resourceFinder.addItem(myResultSet.getString("TABLE_NAME"));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void showInfoText(String table){

        ArrayList<String> fields=new ArrayList<>();
        String consultation="SELECT * FROM " + table;

        try{
            resourceInfo.setText("");

            Statement statement=coneccion.createStatement();
            ResultSet myResultSet=statement.executeQuery(consultation);
            ResultSetMetaData resultSetDataBase=myResultSet.getMetaData();

            for (int i = 1; i <=resultSetDataBase.getColumnCount(); i++)
            {fields.add(resultSetDataBase.getColumnLabel(i));}

            while (myResultSet.next()){
                for(String fieldName:fields)
                {resourceInfo.append(myResultSet.getString(fieldName)+" ");}

                resourceInfo.append("\n");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private JComboBox resourceFinder;
    private JTextArea resourceInfo;
    private Connection coneccion;
    private FileReader entry;
}
