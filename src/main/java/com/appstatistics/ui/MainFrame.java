package com.appstatistics.ui;

import com.appstatistics.collection.LinkedListImp;
import com.appstatistics.data.Data;
import com.appstatistics.operation.Operation;
import com.appstatistics.operation.exception.OperationException;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JFileChooser file;

    private JButton button;

    private Data data;

    private JPanel panel;

    private JLabel size;

    private  JLabel average;

    private  JLabel deviation;

    /**
     * Ventana Principal
     */
    public MainFrame(){
        super("Statistics");
        data = new Data();
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        prepareElementos();
        prepareEventos();
        validate();
    }

    private void prepareEventos() {
        button.addActionListener(e -> {
         try {
             loadData();
         }catch(Exception f){
             JOptionPane.showMessageDialog(null,"No se pudo cargar data o no se pudieron realizar las operaciones");
         }
        });
    }

    private void prepareElementos() {
        button = new JButton("Load Data");
        add(button, BorderLayout.SOUTH);
        button.setBackground(Color.white);
        file = new JFileChooser();
        panel=new JPanel();
        add(panel);
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(3,2));
        JLabel t1 = new JLabel("Numero Datos");
        panel.add(t1);
        size=new JLabel("");
        panel.add(size);
        JLabel t2 = new JLabel("Promedio");
        panel.add(t2);
        average=new JLabel("");
        panel.add(average);
        JLabel t3 = new JLabel("Desviacion");
        panel.add(t3);
        deviation=new JLabel("");
        panel.add(deviation);
    }

    private void loadData() throws OperationException {
        int op = file.showOpenDialog(null);
        if(op==JFileChooser.APPROVE_OPTION){
            LinkedListImp list = data.getData(file.getSelectedFile());
            showData(list);
        }
    }

    private void showData(LinkedListImp list) throws OperationException {
        int len = list.length();
        double av = Operation.average(list);
        double sig = Operation.deviation(list);
        size.setText(String.valueOf(len));
        average.setText(String.valueOf(av));
        deviation.setText(String.valueOf(sig));
    }


}
