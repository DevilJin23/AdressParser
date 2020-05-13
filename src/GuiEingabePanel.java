import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuiEingabePanel extends JPanel implements ActionListener {
    private JButton startButton, editButton, saveButton, loadButton;
    private JTextArea eingabeTextArea;

    public GuiEingabePanel() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel eingabeLabel = new JLabel("Eingabe: ");

        startButton = new JButton("Go");
        startButton.addActionListener(this);
        editButton = new JButton("Bearbeiten");
        editButton.addActionListener(this);
        saveButton = new JButton("Speichern");
        saveButton.addActionListener(this);
        loadButton = new JButton("Suchen");
        loadButton.addActionListener(this);

        eingabeTextArea = new JTextArea("", 2, 50);
        eingabeTextArea.setBackground(Color.yellow);

        panel1.add(eingabeLabel);
        panel1.add(eingabeTextArea);
        panel2.add(startButton);
        panel2.add(editButton);
        panel2.add(saveButton);
        panel2.add(loadButton);

        this.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            System.out.println("GO");
            // TODO: implement call to parsing logic
        }
        else if (ae.getSource() == editButton) {
            System.out.println("edit");
            // TODO: implement edit dialog
        }
        else if (ae.getSource() == saveButton || ae.getSource() == loadButton) {
//            JDialog errorDialog = new JDialog(GuiMainFrame.getInstance(), "CRM-Fehler");
//            errorDialog.setSize(300, 100);
//            errorDialog.getContentPane().add(new JLabel("Fehler: Es ist kein CRM-System verfügbar"));
//            errorDialog.setVisible(true);
            GuiStatusPanel statusPanel  = GuiMainFrame.getInstance().getStatusPanel();
            statusPanel.setStatusTextFeld("CRM-Fehler: Es ist kein CRM System vorhanden");
            statusPanel.setStatus(true);
        }
    }

}
