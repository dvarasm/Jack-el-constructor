package Vista;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class QuitBoton extends JButton {

    private PanelBotones _panel;

    public QuitBoton(PanelBotones panel) {
        super("Salir");
        this.addActionListener(new QuitListener());
        _panel = panel;
    }

    private class QuitListener implements
            java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
