package Base;

public class Material {

    protected double _precio;

    public Material(double precio) {
        _precio = precio;
    }

    public double getPrecio() {
        return _precio;
    }

    public void setPrecio() {
        double tmp = _precio * 0.01;
        _precio = _precio + tmp;
    }
}
