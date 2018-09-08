package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private Jack jack = new Jack();
    private Tablero _tablero = new Tablero();
    private PanelBotones _botones = new PanelBotones(jack, _tablero, this);

    public MainFrame() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 600));
        _tablero.agregarPanelAdelante(0, 0, jack);
        _tablero.crearMaterial("trigo");
        _tablero.crearMaterial("madera");
        _tablero.crearMaterial("piedra");
        _tablero.crearMaterial("adobe");
        this.add(_tablero, BorderLayout.CENTER);
        this.add(_botones, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
