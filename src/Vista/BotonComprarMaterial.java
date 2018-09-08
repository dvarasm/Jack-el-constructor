package Vista;

import Base.*;
import MotorJuego.MotorJuego;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BotonComprarMaterial extends JButton {

    private Tablero _miTablero;
    private Jack _jack;
    private MainFrame frame;
    private MotorJuego _mt;
    private JLabel _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo;
    private Material _adobe, _madera, _piedra, _trigo;
    private int _X, _Y;

    public BotonComprarMaterial(Jack jack, Tablero miTablero, MainFrame f, MotorJuego mt, JLabel dinero, JLabel botonadobe, JLabel botonmadera, JLabel botonpiedra, JLabel botontrigo, Material adobe, Material madera, Material piedra, Material trigo) {
        super("Comprar Material");
        this.addActionListener(new Accion());
        _miTablero = miTablero;
        _jack = jack;
        frame = f;
        _mt = mt;
        _dinero = dinero;
        _botonadobe = botonadobe;
        _botonmadera = botonmadera;
        _botonpiedra = botonpiedra;
        _botontrigo = botontrigo;
        _adobe = adobe;
        _madera = madera;
        _piedra = piedra;
        _trigo = trigo;
    }

    private class Accion implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _X = _jack.positionX();
            _Y = _jack.positionY();

            if (_X == 0 && _Y == 0) {
                if (_mt.comprarMaterial(_trigo) == false) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No tiene recursos suficientes");
                }
            }
            if (_X == 0 && _Y == 7) {
                if (_mt.comprarMaterial(_adobe) == false) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No tiene recursos suficientes");
                }
            }
            if (_X == 7 && _Y == 0) {
                if (_mt.comprarMaterial(_piedra) == false) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No tiene recursos suficientes");
                }
            }
            if (_X == 7 && _Y == 7) {
                if (_mt.comprarMaterial(_madera) == false) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No tiene recursos suficientes");
                }
            }
            _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
        }
    }
}
