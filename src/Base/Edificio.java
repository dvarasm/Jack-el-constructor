package Base;

import MotorJuego.MotorJuego;

public abstract class Edificio {

    protected int _valorVenta;
    protected Material _adobe, _madera, _piedra, _trigo;
    protected MotorJuego _mt;

    public Edificio(MotorJuego mt, Material adobe, Material madera, Material piedra, Material trigo, int valor) {
        _mt = mt;
        _adobe = adobe;
        _madera = madera;
        _piedra = piedra;
        _trigo = trigo;
        _valorVenta = valor;
    }

    public abstract boolean construirme();

    public boolean venderme (){
        return true;
    }

    public void coste() {
    }

    public int getValorVenta() {
        return _valorVenta;
    }

}
