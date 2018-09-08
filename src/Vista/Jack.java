package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Jack extends JPanel {

    private static int X = 0, Y = 0;
    private Image Img;

    public Jack() {
        this.setBackground(Color.yellow);
        URL urlBackgroundImg = getClass().getResource("jack.png");
        this.Img = new ImageIcon(urlBackgroundImg).getImage();
    }

    public int subir() {
        if (X > 0) {
            X -= 1;
        }
        return X;
    }

    public int bajar() {
        if (X < 7) {
            X += 1;
        }
        return X;
    }

    public int izquierda() {
        if (Y > 0) {
            Y -= 1;
        }
        return Y;
    }

    public int derecha() {
        if (Y < 7) {
            Y += 1;
        }
        return Y;
    }

    public int positionY() {
        return Y;
    }

    public int positionX() {
        return X;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Img, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
