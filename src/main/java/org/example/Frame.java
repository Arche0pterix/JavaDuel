package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(150,200);
        JButton button = new JButton("This Button");
        button.setVisible(true);
        button.setAlignmentX(100.4f);
        frame.add(button);
        JTextField textField = new JTextField();
        frame.add(textField);
        JTextPane pane = new JTextPane();
        frame.add(pane);
        pane.setBackground(Color.GREEN);
        pane.setBounds(0,0, 100, 100);
        textField.setBounds(0,110,100,20);
        button.setBounds(0,140,100,40);
        button.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(textField.getText());
                if(textField.getText().toLowerCase().equals("exit")){
                    System.exit(0);
                }
            }
        });
    }



    
}


