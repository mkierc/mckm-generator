import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.*;

public class MCKMGenerator {
    class Okno extends JWindow {
        private static final String SLOWO_NA_DZIS = "S³owo na dziœ: ";
        private JLabel label;
        private JButton losujButton;
        private JButton zamknijButton;
        private Panel buttonPanel;

        public Okno() {
            super();
            Date date = new Date();
            long seed = date.getYear() + date.getMonth() + date.getDay() * 31;
            final String mckmWord = MCKMWordFactory.getMCKMWord(seed);
            BorderLayout borderLayout = new BorderLayout();
            this.setLayout(borderLayout);
            label = new JLabel(SLOWO_NA_DZIS + mckmWord);
            label.setOpaque(true);
            //label.setForeground(new Color(204, 120, 50));
            //label.setBackground(new Color(43, 43, 43));
            label.setFont(new Font("Arial", Font.BOLD, 40));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            losujButton = new JButton("Losuj");
            zamknijButton = new JButton("Zamknij");
            buttonPanel = new Panel();
            buttonPanel.setLayout(new FlowLayout());
            //buttonPanel.setBackground(new Color(60, 63, 65));
            buttonPanel.add(losujButton);
            buttonPanel.add(zamknijButton);

            add(label, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.CENTER);

            losujButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mckm = MCKMWordFactory.getMCKMWord(0);
                    label.setText(SLOWO_NA_DZIS + mckm);
                }
            });

            zamknijButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            addMouseMotionListener(new MouseMotionListener() {
                private int mx, my;

                @Override
                public void mouseMoved(MouseEvent e) {
                    mx = e.getXOnScreen();
                    my = e.getYOnScreen();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point p = Okno.this.getLocation();
                    p.x += e.getXOnScreen() - mx;
                    p.y += e.getYOnScreen() - my;
                    mx = e.getXOnScreen();
                    my = e.getYOnScreen();
                    Okno.this.setLocation(p);
                }
            });
        }

    }

    static class MCKMWordFactory {
        public static String getMCKMWord(long seed) {
            java.util.List mckmList = new ArrayList<String>();
            mckmList.add("znakomicie");
            mckmList.add("wyœmienicie");
            mckmList.add("œwietnie");
            mckmList.add("przeœwietnie");
            mckmList.add("pierwszorzêdnie");
            mckmList.add("wybornie");
            mckmList.add("przewybornie");
            mckmList.add("idealnie");
            mckmList.add("fantastycznie");
            mckmList.add("genialnie");
            mckmList.add("wspaniale");
            mckmList.add("przednio");
            mckmList.add("perfekcyjnie");
            mckmList.add("fenomenalnie");
            mckmList.add("rewelacyjnie");
            mckmList.add("kapitalnie");
            mckmList.add("bosko");
            mckmList.add("cudownie");
            mckmList.add("wzorowo");
            mckmList.add("bezkonkurencyjnie");
            mckmList.add("nadzwyczajnie");
            mckmList.add("wyborowo");
            mckmList.add("mistrzowsko");
            mckmList.add("nieprzeciêtnie");
            mckmList.add("setnie");
            mckmList.add("znakomicie");
            Random random;
            if (seed != 0)
                random = new Random(seed);
            else
                random = new Random();
            return (String)mckmList.get(random.nextInt(mckmList.size()));
        }
    }

    public static void main(String args[]) {
        MCKMGenerator mckmGenerator = new MCKMGenerator();

        String style = readSettings();

        try {
            UIManager.setLookAndFeel(style);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Okno okno = mckmGenerator.new Okno();

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
