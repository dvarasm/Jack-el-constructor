package Base;

import MotorJuego.MotorJuego;

public class Casa extends Edificio {

    public Casa(MotorJuego mt, Material adobe, Material madera, Material piedra, Material trigo, int valor) {
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
        if (_mt.CantidadMaterialJack(_adobe) >= 1 && _mt.CantidadMaterialJack(_madera) >= 1 && _mt.CantidadMaterialJack(_piedra) >= 1 && _mt.CantidadMaterialJack(_trigo) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void coste() {
        _mt.SetRemoveCantidadMaterialJack(_adobe);
        _mt.SetRemoveCantidadMaterialJack(_madera);
        _mt.SetRemoveCantidadMaterialJack(_piedra);
        _mt.SetRemoveCantidadMaterialJack(_trigo);
    }

}
