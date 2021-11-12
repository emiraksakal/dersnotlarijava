package newp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements  ActionListener {

    GraphicsDemo graphicsDemo = new GraphicsDemo();

    JButton square = new JButton("SQUARE");
    JButton circle = new JButton("CIRCLE");
    JButton rect = new JButton("RECTANGLE");
    JButton line = new JButton("LINE");

    public MyFrame() {
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        square.setBounds(20,10,120,50);
        circle.setBounds(20,62,120,50);
        rect.setBounds(20,114,120,50);
        line.setBounds(20,166,120,50);

        square.addActionListener(this);
        circle.addActionListener(this);
        rect.addActionListener(this);
        line.addActionListener(this);

        this.add(square);
        this.add(circle);
        this.add(rect);
        this.add(line);

        this.add(graphicsDemo);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==circle) {
            GraphicsDemo graphicsDemo1 = new GraphicsDemo();
            this.add(graphicsDemo1);
        }
        if (e.getSource()==rect) {

        }
        if (e.getSource()==square) {

        }
        if (e.getSource()==line) {

        }
    }
}
