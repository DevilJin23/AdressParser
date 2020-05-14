import java.awt.*;
import javax.swing.*;

/**
 * @class GuiMainFrame	is a JFrame containing a JPanel with a BorderLayout, containing the GuiEingabePanel in the north, the GuiStatusPanel in the center and the GuiAusgabePanel in the south.
 */
public class GuiMainFrame extends javax.swing.JFrame {
    private static GuiMainFrame mainFrame;
    private JPanel mainPanel;
    private GuiAusgabePanel ausgabePanel;
    private GuiStatusPanel statusPanel;
    private GuiEingabePanel eingabePanel;

    public GuiMainFrame(int sizeX, int sizeY, String title) {
        this.setTitle(title);
        this.setSize(sizeX, sizeY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.getContentPane().add(mainPanel);
        ausgabePanel = new GuiAusgabePanel();
        statusPanel = new GuiStatusPanel();
        eingabePanel = new GuiEingabePanel();

        mainPanel.add(eingabePanel, BorderLayout.NORTH);
        mainPanel.add(statusPanel, BorderLayout.CENTER);
        mainPanel.add(ausgabePanel, BorderLayout.SOUTH);

        this.setVisible(true);
        mainFrame = this;
    }

    /**
     * if there is no mainFrame instance, one will be created and returned.
     * @return 	returns the mainFrame instance of GuiFrame
     */
    public static GuiMainFrame getInstance() {
        if (mainFrame == null)
            mainFrame = new GuiMainFrame(1200, 400, "Kontaktsplitter");
        return mainFrame;
    }

    public GuiEingabePanel getEingabePanel() {
        return eingabePanel;
    }
    public GuiAusgabePanel getAusgabePanel() {
        return ausgabePanel;
    }
    public GuiStatusPanel getStatusPanel() {
        return statusPanel;
    }

}
