package newp;

import javax.swing.*;
import java.awt.*;

public class GraphicsDemo extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      //  this.setBackground(Color.BLACK);

        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.red);
        graphics2D.drawLine(50,20, 50,40);

    }
}
