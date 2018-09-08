package Vista;

import Base.Material;
import MotorJuego.MotorJuego;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BotonVender extends JButton {

    private Tablero _miTablero;
    private Jack _jack;
    private MainFrame frame;
    private MotorJuego _mt;
    private JLabel _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo;
    private Material _adobe, _madera, _piedra, _trigo;
    private int _X, _Y;

    public BotonVender(Jack jack, Tablero miTablero, MainFrame f, MotorJuego mt, JLabel dinero, JLabel botonadobe, JLabel botonmadera, JLabel botonpiedra, JLabel botontrigo, Material adobe, Material madera, Material piedra, Material trigo) {
        super("Vender");
        this.addActionListener(new Accion());
        _miTablero = miTablero;
        _jack = jack;
        frame = f;
        _mt = mt;
        _dinero = dinero;
        _adobe = adobe;
        _madera = madera;
        _piedra = piedra;
        _trigo = trigo;
        _botonadobe = botonadobe;
        _botonmadera = botonmadera;
        _botonpiedra = botonpiedra;
        _botontrigo = botontrigo;
    }

    private class Accion implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _X = _jack.positionX();
            _Y = _jack.positionY();

            if (_miTablero.edificiosExistentes(_X, _Y) == false) {
                JOptionPane.showMessageDialog(
                        null,
                        "No existe Edificio para vender en esta Posicion");
            }

            if (_miTablero.edificiosExistentes(_X, _Y) == true) {
                if (_miTablero.noVentaExistentes(_X, _Y) == false) {
                    if (_mt.venderEdificio(_miTablero.nombreEdificio(_X, _Y))) {
                        _miTablero.eliminarEdificio(_X, _Y);
                        _miTablero.setColor(_X, _Y);
                        _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                        _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                        _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                        _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                        _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "No se puede vender!!");
                }
            }
            frame.repaint();
            _miTablero.repaint();

        }

    }
}
