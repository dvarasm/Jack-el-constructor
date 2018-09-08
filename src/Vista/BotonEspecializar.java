package Vista;

import MotorJuego.MotorJuego;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BotonEspecializar extends JButton {

    private Tablero _miTablero;
    private Jack _jack;
    private MainFrame frame;
    private MotorJuego _mt;
    private JLabel _dinero, _adobe, _madera, _piedra, _trigo;
    private int _X, _Y;

    public BotonEspecializar(Jack jack, Tablero miTablero, MainFrame f, MotorJuego mt, JLabel dinero, JLabel adobe, JLabel madera, JLabel piedra, JLabel trigo) {
        super("Especializar");
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
    }

    private class Accion implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            _X = _jack.positionX();
            _Y = _jack.positionY();
            String tmp = "taller";
            if (_miTablero.edificiosExistentes(_X, _Y) == true) {
                if (tmp.equals(_miTablero.nombreTaller(_X, _Y))) {
                    if (_miTablero.getTallerEspecificado(_X, _Y) == false) {
                        String tmp2 = (String) JOptionPane.showInputDialog(
                                null,
                                "En que material desea especializar el Taller ?",
                                "Selector de opciones",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                new String[]{"adobe", "madera", "piedra", "trigo"},
                                "adobe");
                        _miTablero.setTallerEspecicado(_X, _Y);
                        _miTablero.tallerEspecifico(tmp2);
                    }
                }
            }
            frame.repaint();
            _miTablero.repaint();
        }
    }
}
