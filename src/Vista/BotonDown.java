package Vista;

import Base.Material;
import MotorJuego.MotorJuego;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BotonDown extends JButton {

    private Tablero _miTablero;
    private Jack _jack;
    private int _X, _Y;
    private MotorJuego _mt;
    private Material _adobe, _madera, _piedra, _trigo;
    private JLabel _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo;

    public BotonDown(Jack jack, Tablero miTablero, MainFrame f, MotorJuego mt, JLabel dinero, JLabel botonadobe, JLabel botonmadera, JLabel botonpiedra, JLabel botontrigo,Material adobe,Material madera,Material piedra,Material trigo) {
        super("▼");
        this.addActionListener(new Accion());
        _miTablero = miTablero;
        _jack = jack;
        _mt = mt;
        _botonadobe = botonadobe;
        _botonmadera = botonmadera;
        _botonpiedra = botonpiedra;
        _botontrigo = botontrigo;
        _dinero = dinero;
        _adobe = adobe;
        _madera = madera;
        _piedra = piedra;
        _trigo = trigo;
    }

    private class Accion implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _X = _jack.bajar();
            _Y = _jack.positionY();

            if (_X >= 0 && _X <= 7) {
                _miTablero.agregarPanelAdelante(_X, _Y, _jack);
                _miTablero.repaint();
                if (_miTablero.numeroDeGranja() > 0) {
                    _mt.SetAddCantidadMaterialJack(_adobe,_miTablero.numeroDeGranja());
                    _mt.SetAddCantidadMaterialJack(_madera,_miTablero.numeroDeGranja());
                    _mt.SetAddCantidadMaterialJack(_piedra,_miTablero.numeroDeGranja());
                    _mt.SetAddCantidadMaterialJack(_trigo,_miTablero.numeroDeGranja());
                    _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                    _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                    _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                    _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                    _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                }
                String _ADOBE = "adobe";
                String _MADERA = "madera";
                String _PIEDRA = "piedra";
                String _TRIGO = "trigo";
                try {
                    if (_miTablero.cantidadTaller() > 0) {
                        if (_miTablero.Id(_ADOBE) > 0) {
                            _mt.SetAddCantidadMaterialJack(_adobe,(2*_miTablero.Id(_ADOBE)));
                            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                        }
                        if (_miTablero.Id(_MADERA) > 0) {
                            _mt.SetAddCantidadMaterialJack(_madera,(2*_miTablero.Id(_MADERA)));
                            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                        }
                        if (_miTablero.Id(_PIEDRA) > 0) {
                            _mt.SetAddCantidadMaterialJack(_piedra,(2*_miTablero.Id(_PIEDRA)));
                            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                        }
                        if (_miTablero.Id(_TRIGO) > 0) {
                            _mt.SetAddCantidadMaterialJack(_trigo,(2*_miTablero.Id(_TRIGO)));
                            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                        }
                    }
                } catch (Exception f) {
                }
            }
        }
    }
}
