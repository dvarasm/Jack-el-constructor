package Vista;

import Base.*;
import MotorJuego.MotorJuego;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

    private MotorJuego _mt;
    private Edificio _casa, _condominio, _taller, _granja;
    private Material _adobe, _madera, _piedra, _trigo;
    private MainFrame _frame;
    private Jack _jack;
    private Tablero _tablero;
    private JButton _salir, _up, _down, _left, _right, _edificar, _vender, _comprarMaterial, _especializar, _venderMaterial;
    private JPanel _ordenar, _botones, _ordenarFlechas, _ordenarFlechas2, _ordenarFlechas3, _ordenarBotones, _ordenarBotones2, _informacion, _panel1, _panel2;
    private JLabel _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adicional;

    public PanelBotones(Jack jack, Tablero panel, MainFrame f) {
        this.setLayout(new BorderLayout());
        _jack = jack;
        _tablero = panel;
        _frame = f;
        _mt = new MotorJuego();
        _adobe = new Adobe(25);
        _madera = new Madera(25);
        _piedra = new Piedra(25);
        _trigo = new Trigo(25);
        _casa = new Casa(_mt, _adobe, _madera, _piedra, _trigo, 110);
        _condominio = new Condominio(_mt, _adobe, _madera, _piedra, _trigo, 270);
        _taller = new Taller(_mt, _adobe, _madera, _piedra, _trigo, 0);
        _granja = new Granja(_mt, _adobe, _madera, _piedra, _trigo, 0);
        _informacion = new JPanel(new GridLayout(3, 2, 1, 1));
        _panel1 = new JPanel(new BorderLayout());
        _panel2 = new JPanel(new BorderLayout());
        _botones = new JPanel(new BorderLayout());
        _ordenar = new JPanel(new BorderLayout());
        _ordenarFlechas = new JPanel(new BorderLayout());
        _ordenarFlechas2 = new JPanel(new GridLayout());
        _ordenarFlechas3 = new JPanel(new GridLayout());
        _ordenarBotones = new JPanel(new GridLayout());
        _ordenarBotones2 = new JPanel(new GridLayout());
        _dinero = new JLabel("Dinero :" + _mt.CantidadDineroJack());
        _botonadobe = new JLabel("Adobe :" + _mt.CantidadMaterialJack(_adobe));
        _botonmadera = new JLabel("Madera :" + _mt.CantidadMaterialJack(_madera));
        _botonpiedra = new JLabel("Piedra :" + _mt.CantidadMaterialJack(_piedra));
        _botontrigo = new JLabel("Trigo :" + _mt.CantidadMaterialJack(_trigo));

        _salir = new QuitBoton(this);
        _up = new BotonUp(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _down = new BotonDown(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _left = new BotonLeft(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _right = new BotonRight(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _edificar = new BotonEdificar(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo, _casa, _condominio, _taller, _granja);
        _vender = new BotonVender(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _comprarMaterial = new BotonComprarMaterial(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);
        _especializar = new BotonEspecializar(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo);
        _venderMaterial = new BotonVenderMaterial(_jack, _tablero, _frame, _mt, _dinero, _botonadobe, _botonmadera, _botonpiedra, _botontrigo, _adobe, _madera, _piedra, _trigo);

        _informacion.add(_dinero);
        _informacion.add(_botonadobe);
        _informacion.add(_botonmadera);
        _informacion.add(_botonpiedra);
        _informacion.add(_botontrigo);

        _panel2.add(_especializar);
        _ordenarBotones.add(_comprarMaterial);
        _ordenarBotones.add(_venderMaterial);
        _ordenarBotones2.add(_vender);
        _ordenarBotones2.add(_up);
        _ordenarBotones2.add(_edificar);

        _ordenarFlechas2.add(_left);
        _ordenarFlechas2.add(_down);
        _ordenarFlechas2.add(_right);
        _ordenarFlechas3.add(_salir);

        _panel1.add(_informacion, BorderLayout.CENTER);
        _panel1.add(_panel2, BorderLayout.SOUTH);

        _botones.add(_ordenar, BorderLayout.NORTH);
        _botones.add(_ordenarFlechas, BorderLayout.SOUTH);
        _ordenar.add(_ordenarBotones, BorderLayout.NORTH);
        _ordenar.add(_ordenarBotones2, BorderLayout.SOUTH);
        _ordenarFlechas.add(_ordenarFlechas2, BorderLayout.NORTH);
        _ordenarFlechas.add(_ordenarFlechas3, BorderLayout.SOUTH);
        this.add(_panel1, BorderLayout.CENTER);
        this.add(_botones, BorderLayout.SOUTH);
    }
}
