import javax.swing.*;
import java.awt.*;

public class GuiStatusPanel extends JPanel {
    private JTextField statusTextFeld;

    public GuiStatusPanel() {
        JLabel statusLabel = new JLabel("Status: ");
        statusTextFeld = new JTextField("", 30);
        statusTextFeld.setEditable(false);
        this.add(statusLabel);
        this.add(statusTextFeld);
    }

    public void setStatusTextFeld(String text) {
        statusTextFeld.setText(text);
    }
    public void setStatus(boolean error) {
        if (error) statusTextFeld.setForeground(Color.red);
        else statusTextFeld.setForeground(Color.gray);
    }
}
