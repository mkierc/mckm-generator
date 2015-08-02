import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MCKMGenerator {
    @SuppressWarnings("StaticVariableMayNotBeInitialized")
    public static MCKMWindow okno;
    public static Map<String, String> settings = new HashMap<>();

    public static void main(String args[]) {
        settings = MCKMUtils.readSettings();

        try {
            UIManager.setLookAndFeel(settings.get("style"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        okno = new MCKMWindow();

        okno.setSize(700, 100);
        okno.setLocation(Integer.parseInt(settings.get("xpos")), Integer.parseInt(settings.get("ypos")));
        okno.setAlwaysOnTop(true);
        okno.setVisible(true);
    }

    @SuppressWarnings("StaticVariableUsedBeforeInitialization")
    public static void restart() {
        okno.dispose();
        try {
            UIManager.setLookAndFeel(settings.get("style"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        okno = new MCKMWindow();

        okno.setSize(700, 100);
        okno.setLocation(Integer.parseInt(settings.get("xpos")), Integer.parseInt(settings.get("ypos")));
        okno.setAlwaysOnTop(true);
        okno.setVisible(true);
    }
}
