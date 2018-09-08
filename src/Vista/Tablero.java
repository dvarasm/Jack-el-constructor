package Vista;

import Base.Edificio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    private JPanel[][] miPanel = new JPanel[8][8];
    private boolean[][] edificio = new boolean[8][8];
    private boolean[][] noVenta = new boolean[8][8];
    private boolean[][] tallerEspecificado = new boolean[8][8];
    private Edificio[][] nombre = new Edificio[8][8];
    private String[][] tallerandgranja = new String[8][8];
    private int[] cantidad = new int[60];
    private String[] Id = new String[60];
    private int i = 0;
    private int p = 0;

    public Tablero() {
        this.setLayout(new GridLayout(8, 8));
        for (int X = 0; X < 8; X++) {
            for (int Y = 0; Y < 8; Y++) {
                Panel panel = new Panel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                miPanel[X][Y] = panel;
                miPanel[X][Y].setLayout(new GridLayout());
                miPanel[X][Y].setBackground(Color.WHITE);
                this.add(miPanel[X][Y]);
            }
        }
    }

    public void addNombreEdificio(int X, int Y, Edificio _nombre) {
        nombre[X][Y] = _nombre;
    }

    public String nombreTaller(int X, int Y) {
        return tallerandgranja[X][Y];
    }

    public Edificio nombreEdificio(int X, int Y) {
        return nombre[X][Y];
    }

    public int numeroDeGranja() {
        String _GRANJA = "granja";
        int tmp = 0;
        for (int k = 0; k < 8; k++) {
            for (int j = 0; j < 8; j++) {
                if (_GRANJA.equals(tallerandgranja[k][j])) {
                    tmp++;
                }
            }
        }
        return tmp;
    }

    public boolean edificiosExistentes(int X, int Y) {
        if (edificio[X][Y] == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean noVentaExistentes(int X, int Y) {
        if (noVenta[X][Y] == true) {
            return true;
        } else {
            return false;
        }
    }

    public void guardarNoVenta(int X, int Y) {
        noVenta[X][Y] = true;
    }

    public void guardarEdificio(int X, int Y) {
        edificio[X][Y] = true;
    }

    public void eliminarEdificio(int X, int Y) {
        edificio[X][Y] = false;
    }

    public void agregarPanelAdelante(int X, int Y, JPanel _panel) {
        miPanel[X][Y].add(_panel, BorderLayout.CENTER, 0);

    }

    public void agregarPanelAtras(int X, int Y, JPanel _panel) {
        miPanel[X][Y].add(_panel, BorderLayout.CENTER, 1);
    }

    public void crearMaterial(String tipo) {
        if (tipo.equals("trigo")) {
            guardarEdificio(0, 0);
            guardarNoVenta(0, 0);
            miPanel[0][0].setBackground(Color.YELLOW);
        }
        if (tipo.equals("adobe")) {
            guardarEdificio(0, 7);
            guardarNoVenta(0, 7);
            miPanel[0][7].setBackground(Color.RED);
        }
        if (tipo.equals("piedra")) {
            guardarEdificio(7, 0);
            guardarNoVenta(7, 0);
            miPanel[7][0].setBackground(Color.DARK_GRAY);
        }
        if (tipo.equals("madera")) {
            guardarEdificio(7, 7);
            guardarNoVenta(7, 7);
            miPanel[7][7].setBackground(new Color(156, 93, 82));
        }
    }

    public void crearEdificio(String tipo, int X, int Y) {
        if (tipo.equals("casa")) {
            guardarEdificio(X, Y);
            miPanel[X][Y].setBackground(Color.GREEN);
        }
        if (tipo.equals("condominio")) {
            guardarEdificio(X, Y);
            miPanel[X][Y].setBackground(Color.BLACK);
        }
        if (tipo.equals("taller")) {
            guardarEdificio(X, Y);
            guardarNoVenta(X, Y);
            tallerandgranja[X][Y] = "taller";
            miPanel[X][Y].setBackground(Color.PINK);
            p++;
        }
        if (tipo.equals("granja")) {
            guardarEdificio(X, Y);
            guardarNoVenta(X, Y);
            tallerandgranja[X][Y] = "granja";
            miPanel[X][Y].setBackground(Color.BLUE);
        }
    }

    public void tallerEspecifico(String _nombre) {
        Id[i] = _nombre;
        i++;
    }

    public int cantidadTaller() {
        return p;
    }

    public int Id(String tipo) {
        int tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0;
        String _ADOBE = "adobe";
        String _MADERA = "madera";
        String _PIEDRA = "piedra";
        String _TRIGO = "trigo";
        try {
            for (int j = 0; j < i; j++) {
                if (Id[j].equals(_TRIGO)) {
                    tmp1 += 1;
                }
                if (Id[j].equals(_ADOBE)) {
                    tmp2 += 1;
                }
                if (Id[j].equals(_PIEDRA)) {
                    tmp3 += 1;
                }
                if (Id[j].equals(_MADERA)) {
                    tmp4 += 1;
                }
            }

            if (tipo.equals(_TRIGO)) {
                return tmp1;
            }
            if (tipo.equals(_ADOBE)) {
                return tmp2;
            }
            if (tipo.equals(_PIEDRA)) {
                return tmp3;
            }
            if (tipo.equals(_MADERA)) {
                return tmp4;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void setTallerEspecicado(int X, int Y) {
        tallerEspecificado[X][Y] = true;
    }

    public boolean getTallerEspecificado(int X, int Y) {
        return tallerEspecificado[X][Y];
    }

    public void setColor(int X, int Y) {
        miPanel[X][Y].setBackground(Color.WHITE);
    }
}
