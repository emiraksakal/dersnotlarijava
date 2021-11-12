package newp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    DragPanel dragPanel = new DragPanel();
    JButton square = new JButton("SQUARE");
    JButton circle = new JButton("CIRCLE");
    JButton rect = new JButton("RECTANGLE");
    JButton line = new JButton("LINE");
    ImageIcon  image = new ImageIcon("daire.png");



    MyFrame(){

     square.setBounds(20,10,120,50);
       circle.setBounds(20,62,120,50);
       rect.setBounds(20,114,120,50);
       line.setBounds(20,166,120,50);

        square.addActionListener(this);
        circle.addActionListener(this);
        rect.addActionListener(this);
        line.addActionListener(this);



        this.add(dragPanel);
        this.setTitle("Drawing Editor");
        this.setSize(600, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(square);
        this.add(circle);
        this.add(rect);
        this.add(line);
        this.setVisible(true);

    }


        @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==circle) {

        }
        if (e.getSource()==rect) {
            ImageIcon  image = new ImageIcon("dikd.png");
            dragPanel.image=image;
        }
        if (e.getSource()==square) {
            ImageIcon  image = new ImageIcon("kare.png");
            dragPanel.image=image;
        }
        if (e.getSource()==line) {
            ImageIcon  image = new ImageIcon("cizgi.png");
            dragPanel.image=image;
        }

    }
}
