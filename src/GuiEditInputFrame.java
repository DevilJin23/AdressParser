import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * @class GuiEditInputFrame	is a JFrame containing the mainPanel with a BorderLayout, containing a vertical JSplitPane in the North (with panel1 above and panel2 below) and panel3 in the South.
 *
 * panel1 contains four JLabels, two JComboBoxes (for selecting salutation and title) and two JTextFields (for editing first name and surname)-
 * panel2 contains two JLabels, two JTextFields (for entering new entries for salutation and title lists) and four JButtons (for adding new sentries to salutation and title lists and for deleting selected entries)
 * panel3 contains two JButtons, the cancelButton simply disposes the GuiEditInputFrame, the okButton applies all values from the JTextFields and JComboBoxes to the GuiAusgabePanel and saves the salutation and title lists persistently to a file, before disposing the GuiEditInputFrame.
 */
public class GuiEditInputFrame extends javax.swing.JFrame implements ActionListener {
    private JPanel mainPanel, upperPanel, lowerPanel, panel0, panel1, panel2, panel3;
    private JLabel anredeLabel, titelLabel, geschlechtLabel, vornameLabel, nachnameLabel, newAnredeLabel, newTitelLabel;
    private JTextField newAnredeTextFeld, newTitelTextFeld, vornameTextFeld, nachnameTextFeld;
    private JComboBox anredeAuswahl, titelAuswahl, geschlechtAuswahl;
    private JButton okButton, cancelButton, addNewAnredeButton, addNewTitelButton, deleteAnredeButton, deleteTitelButton;

    public GuiEditInputFrame() {
        mainPanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        panel0 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        anredeLabel = new JLabel("Anrede: ");
        titelLabel = new JLabel("Titel: ");
        geschlechtLabel = new JLabel("Geschlecht: ");
        vornameLabel = new JLabel("Vorname: ");
        nachnameLabel = new JLabel("Nachname: ");
        newAnredeLabel = new JLabel("Neue Anrede: ");
        newTitelLabel = new JLabel("Neuer Titel: ");

        // TODO: gleich befüllen mit geparsten Teilen der Eingabe
        newAnredeTextFeld = new JTextField("",5);
        newTitelTextFeld = new JTextField("",20);
        vornameTextFeld = new JTextField("",20);
        nachnameTextFeld = new JTextField("",30);

        // TODO: Liste aller gespeicherten Anreden abrufen (Liste oder Array mit Strings), für Bestückung der ComboBox
        String[] anredeListe = {"Herr", "Frau", "Herr/Frau"};
        anredeAuswahl = new JComboBox(anredeListe);
        // TODO: Liste aller gespeicherten Titel abrufen (Liste oder Array mit Strings), für Bestückung der ComboBox
        String[] titelListe = {"Dr.", "Dr. med.", "Dr. habil.", "Dr. rer. nat.", "Prof. Dr.", "Dipl. Ing.", "Prof. Dr. Ing."};
        titelAuswahl = new JComboBox(titelListe);
        String[] genders = {"männlich", "weiblich", "divers"};
        geschlechtAuswahl = new JComboBox(genders);

        okButton = new JButton("OK");
        okButton.addActionListener(this);
        cancelButton = new JButton("Abbrechen");
        cancelButton.addActionListener(this);
        addNewAnredeButton = new JButton("Anrede hinzufügen");
        addNewAnredeButton.addActionListener(this);
        addNewTitelButton = new JButton("Titel hinzufügen");
        addNewTitelButton.addActionListener(this);
        deleteAnredeButton = new JButton("Anrede löschen");
        deleteAnredeButton.addActionListener(this);
        deleteTitelButton = new JButton("Titel löschen");
        deleteTitelButton.addActionListener(this);

        panel0.add(vornameLabel);
        panel0.add(vornameTextFeld);
        panel0.add(nachnameLabel);
        panel0.add(nachnameTextFeld);

        panel1.add(anredeLabel);
        panel1.add(anredeAuswahl);
        panel1.add(geschlechtLabel);
        panel1.add(geschlechtAuswahl);
        panel1.add(titelLabel);
        panel1.add(titelAuswahl);

        panel2.add(newAnredeLabel);
        panel2.add(newAnredeTextFeld);
        panel2.add(addNewAnredeButton);
        panel2.add(deleteAnredeButton);
        panel2.add(newTitelLabel);
        panel2.add(newTitelTextFeld);
        panel2.add(addNewTitelButton);
        panel2.add(deleteTitelButton);


        panel3.add(okButton);
        panel3.add(cancelButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(lowerPanel, BorderLayout.SOUTH);
        upperPanel.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel0, panel1));
        lowerPanel.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel2, panel3));

        this.add(mainPanel);
        this.setTitle("Eingabe Bearbeiten");
        this.setSize(1200, 300);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == okButton) {
            GuiAusgabePanel ausgabePanel = GuiMainFrame.getInstance().getAusgabePanel();
            ausgabePanel.setAnredeTextFeld(getAnrede());
            ausgabePanel.setTitelTextFeld(getTitel());
            ausgabePanel.setVornameTextFeld(getVorname());
            ausgabePanel.setNachnameTextFeld(getNachname());
            // TODO: GesamtAusgabeTextArea korrekt bestücken
            //ausgabePanel.setGesamtAusgabeTextArea(???);

            // TODO: Liste mit Anreden speichern
            // anredeAuswahl.getModel() liefert Liste oder Array, worauf dann iteriert werden kann
            // TODO: Liste mit Titeln speichern
            // titelAuswahl.getModel() liefert Liste oder Array, worauf dann iteriert werden kann
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }

        else if (ae.getSource() == cancelButton)
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        else if (ae.getSource() == addNewAnredeButton && !getNewAnrede().isEmpty()) {
            System.out.println("neue Anrede hinzugefügt: " + getNewAnrede());
            anredeAuswahl.addItem(getNewAnrede());
        }
        else if (ae.getSource() == addNewTitelButton && !getNewTitel().isEmpty()) {
            System.out.println("neuer Titel hinzugefügt: " + getNewTitel());
            titelAuswahl.addItem(getNewTitel());
        }
        else if (ae.getSource() == deleteAnredeButton && anredeAuswahl.getSelectedItem() != null) {
            System.out.println("Anrede gelöscht: " + anredeAuswahl.getSelectedItem().toString());
            anredeAuswahl.removeItemAt(anredeAuswahl.getSelectedIndex());
        }
        else if (ae.getSource() == deleteTitelButton && titelAuswahl.getSelectedItem() != null) {
            System.out.println("Titel gelöscht: " + titelAuswahl.getSelectedItem().toString());
            titelAuswahl.removeItemAt(titelAuswahl.getSelectedIndex());
        }
    }

    public String getNewAnrede() {
        if (newAnredeTextFeld == null) return "";
        else return newAnredeTextFeld.getText();
    }
    public String getNewTitel() {
        if (newTitelTextFeld.getText() == null) return "";
        else return newTitelTextFeld.getText();
    }
    public String getVorname() {
        if (vornameTextFeld.getText() == null) return "";
        else return vornameTextFeld.getText();
    }
    public String getNachname() {
        if (nachnameTextFeld.getText() == null) return "";
        else return nachnameTextFeld.getText();
    }
    public String getAnrede() {
        if (anredeAuswahl.getSelectedItem() == null) return "";
        else return anredeAuswahl.getSelectedItem().toString();
    }
    public String getTitel() {
        if (titelAuswahl.getSelectedItem() == null) return "";
        else return titelAuswahl.getSelectedItem().toString();
    }
}
