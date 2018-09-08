package Vista;

import Base.Edificio;
import Base.Material;
import MotorJuego.MotorJuego;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BotonEdificar extends JButton {

    private Tablero _miTablero;
    private Jack _jack;
    private MainFrame frame;
    private MotorJuego _mt;
    private JLabel _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo;
    private Material _adobe, _madera, _piedra, _trigo;
    private Edificio _casa, _condominio, _taller, _granja;
    private int _X, _Y;

    public BotonEdificar(Jack jack, Tablero miTablero, MainFrame f, MotorJuego mt, JLabel dinero, JLabel botonadobe, JLabel botonmadera, JLabel botonpiedra, JLabel botontrigo, Material adobe, Material madera, Material piedra, Material trigo, Edificio casa, Edificio condominio, Edificio taller, Edificio granja) {
        super("Edificar");
        this.addActionListener(new Accion());
        _miTablero = miTablero;
        _jack = jack;
        frame = f;
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
        _casa = casa;
        _condominio = condominio;
        _taller = taller;
        _granja = granja;
    }

    private class Accion implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _X = _jack.positionX();
            _Y = _jack.positionY();
            try {
                if (_miTablero.edificiosExistentes(_X, _Y) == true) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ya existe Edificio en Esta Posicion");
                }
                if (_miTablero.edificiosExistentes(_X, _Y) == false) {
                    String tmp = (String) JOptionPane.showInputDialog(
                            null,
                            "Que edificio desea construir?",
                            "Selector de opciones",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"casa", "condominio", "taller", "granja"},
                            "casa");
                    if (tmp.equals("casa")) {
                        if (_mt.Edificar(_casa) == false) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Necesita 1 Adobe, 1 Piedra, 1 Trigo, 1 madera, para construir !!");
                        } else {
                            _miTablero.addNombreEdificio(_X, _Y, _casa);
                            _miTablero.crearEdificio(tmp, _X, _Y);
                            _miTablero.guardarEdificio(_X, _Y);
                            _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                        }
                    }
                    if (tmp.equals("condominio")) {
                        if (_mt.Edificar(_condominio) == false) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Necesita 2 Adobe, 3 Piedra, 2 madera, para construir !!");
                        } else {
                            _miTablero.addNombreEdificio(_X, _Y, _condominio);
                            _miTablero.crearEdificio(tmp, _X, _Y);
                            _miTablero.guardarEdificio(_X, _Y);
                            _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                        }
                    }
                    if (tmp.equals("taller")) {
                        if (_mt.Edificar(_taller) == false) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Necesita 2 Piedra, 2 Trigo, para construir !!");
                        } else {
                            _miTablero.addNombreEdificio(_X, _Y, _taller);
                            _miTablero.crearEdificio(tmp, _X, _Y);
                            _miTablero.guardarEdificio(_X, _Y);
                            _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                        }
                    }
                    if (tmp.equals("granja")) {
                        if (_mt.Edificar(_granja) == false) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Necesita 2 madera, para construir !!");
                        } else {
                            _miTablero.addNombreEdificio(_X, _Y, _granja);
                            _miTablero.crearEdificio(tmp, _X, _Y);
                            _miTablero.guardarEdificio(_X, _Y);
                            _dinero.setText("Dinero :" + _mt.CantidadDineroJack());
                            _botonadobe.setText("Adobe :" + _mt.CantidadMaterialJack(_adobe));
                            _botonpiedra.setText("Piedra :" + _mt.CantidadMaterialJack(_piedra));
                            _botonmadera.setText("Madera :" + _mt.CantidadMaterialJack(_madera));
                            _botontrigo.setText("Trigo :" + _mt.CantidadMaterialJack(_trigo));
                        }
                    }
                }
                frame.repaint();
                _miTablero.repaint();
            } catch (Exception f) {
            }
        }
    }
}
