package Base;

import java.util.ArrayList;

public class Jack {

    private static double _dinero;
    private ArrayList<Material> _materiales = new ArrayList<Material>();
    private ArrayList<Edificio> _edificios = new ArrayList<Edificio>();

    public Jack(double dinero) {
        _dinero = dinero;
    }

    public int cantidadMaterial(Material _material) {
        int _count = 0;
        if (_materiales.size() > 0) {
            for (int i = 0; i < _materiales.size(); i++) {
                if (_materiales.get(i).equals(_material) == true) {
                    _count++;
                }
            }
            return _count;
        } else {
            return _count;
        }
    }

    public int cantidadEdificios(Edificio _edificio) {
        int _count = 0;
        if (_edificios.size() > 0) {
            for (int i = 0; i < _edificios.size(); i++) {
                if (_edificios.get(i).equals(_edificio) == true) {
                    _count++;
                }
            }
            return _count;
        } else {
            return _count;
        }
    }

    public boolean hayMaterial() {
        if (_materiales.isEmpty() == true) {
            return false;
        } else {
            return true;
        }
    }

    public void agregarEdificio(Edificio edificio) {
        _edificios.add(edificio);
    }

    public void agregarMaterial(Material material) {
        _materiales.add(material);
    }

    public void eliminarMaterial(Material material) {
        _materiales.remove(material);
    }

    public void eliminarEdificio(Edificio edificio) {
        _edificios.remove(edificio);
    }

    public double getDinero() {
        return _dinero;
    }

    public void setRemoveDinero(double dinero) {
        _dinero -= dinero;
    }

    public void setAddDinero(double dinero) {
        _dinero += dinero;
    }
}
