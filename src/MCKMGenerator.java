import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class MCKMGenerator {
    public static void main(String args[]) {
        String style = readSettings();

        try {
            UIManager.setLookAndFeel(style);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final MCKMWindow okno = new MCKMWindow();

        okno.setSize(700,100);
        okno.setLocation(100, 100);
        okno.setAlwaysOnTop(true);
        okno.setVisible(true);
    }

    private static String readSettings() {
        Scanner inScanner;
        String style = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            inScanner = new Scanner(new FileReader("settings.dat"));
            while (inScanner.hasNextLine()) {
                String line = inScanner.nextLine();
                if (line.equals("DARK"))
                    style = "com.bulenkov.darcula.DarculaLaf";
                else
                    style = "javax.swing.plaf.metal.MetalLookAndFeel";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return style;
    }
}
