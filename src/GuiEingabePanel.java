import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
* @class GuiUpperPanel	is a JPanel containing a vertical JSplitPane, containing JPanel panel1 (above, contains a JLabel and a JTextArea and a JButton) and JPanel panel2 (below, contains four JButtons).
* 						also is an ActionListener for the clickable JButtons.
*
* the upper JTextArea serves for user input, to enter a salutation and a Name. Pressing the startButton will parse the user input and extract the gender, title, first name and surname.
*/
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

    /**
	* actionPerformed is executed when the user clicks at one of the buttons
	*
    * if the startButton is clicked, the user input is parsed to extract the gender, title, first name and surname.
    * if the editButton is clicked, an EditInputFrame is created which allows the user to correct the input fields if not recognized correctly.
    * if the saveButton is clicked, the current data is saved as a contact in the attached CRM-System. This requires a CRM-System to be attached correctly.
    * if the loadButton is clicked, an existing contact can be loaded from the attached CRM-System. This requires a CRM-System to be attached correctly.
	*
	* @param ae	is auto-generated when the user clicks at a button in the GuiFrame
	*		 ae	contains information about which button was clicked
	*/
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
