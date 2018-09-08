package Base;

import MotorJuego.MotorJuego;

public class Granja extends Edificio {

    public Granja(MotorJuego mt, Material adobe, Material madera, Material piedra, Material trigo, int valor) {
        super(mt, adobe, madera, piedra, trigo, valor);
        _mt = mt;
        _adobe = adobe;
        _madera = madera;
        _piedra = piedra;
        _trigo = trigo;
        _valorVenta = valor;
    }

    @Override
    public boolean construirme() {
        if (_mt.CantidadMaterialJack(_madera) >= 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean venderme() {
        return false;
    }

    @Override
    public void coste() {
        _mt.SetRemoveCantidadMaterialJack(_madera);
        _mt.SetRemoveCantidadMaterialJack(_madera);
    }

}
