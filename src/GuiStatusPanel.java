import javax.swing.*;
import java.awt.*;

/**
 * @class GuiStatusPanel is a JPanel containing a JLabel and a JTextField. The statusTextField shows the current program status and error messages, if an error occurs.
 */
public class GuiStatusPanel extends JPanel {
    private JLabel statusLabel;
    private JTextField statusTextFeld;

    public GuiStatusPanel() {
        statusLabel = new JLabel("Status: ");
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
