import javax.swing.*;
import java.awt.*;

/**
* @class GuiAusgabePanel	is a JPanel containing a vertical JSplitPane, containing JPanel panel1 (above, contains four JLabels and four JTextFields) and JPanel panel2 (below, contains one JLabel and one JTextField).
* 				            also is an ActionListener for the clickable JButtons.
*
* the four JTextFields above serve for output and show the gender, title, first name and surname of the currently parsed person.
* the JTextArea below shows the complete, auto-generated letter salutation for the currently parsed person.
*/
public class GuiAusgabePanel extends JPanel {
    private JTextField anredeTextFeld, titelTextFeld, vornameTextFeld, nachnameTextFeld;
    private JTextArea gesamtAusgabeTextArea;

    public GuiAusgabePanel() {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel anredeLabel = new JLabel("Anrede: ");
    JLabel titelLabel = new JLabel("Titel: ");
    JLabel vornameLabel = new JLabel("Vorname: ");
    JLabel nachnameLabel = new JLabel("Nachname: ");
    JLabel gesamtAusgabeLabel = new JLabel("Briefanrede: ");

    anredeTextFeld = new JTextField("",5);
    anredeTextFeld.setEditable(false);
    titelTextFeld = new JTextField("",20);
    titelTextFeld.setEditable(false);
    vornameTextFeld = new JTextField("",20);
    vornameTextFeld.setEditable(false);
    nachnameTextFeld = new JTextField("",30);
    nachnameTextFeld.setEditable(false);
    gesamtAusgabeTextArea = new JTextArea("",2, 50);
    gesamtAusgabeTextArea.setEditable(false);

    panel1.add(anredeLabel);
    panel1.add(anredeTextFeld);
    panel1.add(titelLabel);
    panel1.add(titelTextFeld);
    panel1.add(vornameLabel);
    panel1.add(vornameTextFeld);
    panel1.add(nachnameLabel);
    panel1.add(nachnameTextFeld);

    panel2.add(gesamtAusgabeLabel);
    panel2.add(gesamtAusgabeTextArea);

    this.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2));
    }

    public void setAnredeTextFeld(String text) {
        anredeTextFeld.setText(text);
    }
    public String getAnrede() {
        return anredeTextFeld.getText();
    }
    public void setTitelTextFeld(String text) {
        titelTextFeld.setText(text);
    }
    public String getTitel() {
        return titelTextFeld.getText();
    }
    public void setVornameTextFeld(String text) {
        vornameTextFeld.setText(text);
    }
    public String getVorname() {
        return vornameTextFeld.getText();
    }
    public void setNachnameTextFeld(String text) {
        nachnameTextFeld.setText(text);
    }
    public String getNachname() {
        return nachnameTextFeld.getText();
    }
    public void setGesamtAusgabeTextArea(String text) {
        gesamtAusgabeTextArea.setText(text);
    }
}
