package Vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    public Panel() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(0, 0, 100, 100);
        super.paint(g);
    }
}
