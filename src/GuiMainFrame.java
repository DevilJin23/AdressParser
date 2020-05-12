import java.awt.*;

public class GuiMainFrame extends javax.swing.JFrame {
    private static GuiMainFrame mainFrame;

    public GuiMainFrame(int sizeX, int sizeY, String title) {
        this.setTitle(title);
        this.setSize(sizeX, sizeY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        mainFrame = this;
    }

    /**
     * if there is no mainFrame instance, one will be created and returned.
     * @return 	returns the mainFrame instance of GuiFrame
     */
    public static GuiMainFrame getInstance() {
        if (mainFrame == null)
            mainFrame = new GuiMainFrame(900, 300, "Kontaktsplitter");
        return mainFrame;
    }

}
