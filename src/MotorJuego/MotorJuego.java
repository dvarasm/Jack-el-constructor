package MotorJuego;

import Base.*;

public class MotorJuego {

    public MotorJuego() {
    }
    private final Jack _jack = new Jack(1000);
    private int count = 0;

    public boolean Edificar(Edificio _edificio) {
        if (_jack.hayMaterial() == true) {
            if (_edificio.construirme() == true) {
                _jack.agregarEdificio(_edificio);
                _edificio.coste();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean comprarMaterial(Material _material) {
        if (_jack.getDinero() > 0) {
            if (_jack.getDinero() >= _material.getPrecio()) {
                _jack.agregarMaterial(_material);
                _jack.setRemoveDinero(_material.getPrecio());
                count++;
                if (count > 20) {
                    _material.setPrecio();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean venderMaterial(Material _material) {
        if (_jack.cantidadMaterial(_material) > 0) {
            _jack.eliminarMaterial(_material);
            ganancia(_material);
            return true;
        } else {
            return false;
        }
    }

    public boolean venderEdificio(Edificio _edificio) {
        if (_jack.cantidadEdificios(_edificio) > 0) {
            if (_edificio.venderme() == true) {
                _jack.eliminarEdificio(_edificio);
                ganancia(_edificio);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public void SetAddCantidadMaterialJack(Material material, int n) {
        for (int i = 0; i < n; i++) {
            _jack.agregarMaterial(material);
        }
    }

    public void SetRemoveCantidadMaterialJack(Material material) {
        _jack.eliminarMaterial(material);
    }

    public int CantidadEdificiosJack(Edificio edificio) {
        return _jack.cantidadEdificios(edificio);
    }

    public int CantidadMaterialJack(Material material) {
        return _jack.cantidadMaterial(material);
    }

    public double CantidadDineroJack() {
        return _jack.getDinero();
    }

    private void ganancia(Edificio edificio) {
        _jack.setAddDinero(edificio.getValorVenta());
    }

    private void ganancia(Material material) {
        _jack.setAddDinero(material.getPrecio());
    }
}
