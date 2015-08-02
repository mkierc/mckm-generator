import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MCKMWindow extends JWindow {
    private static final String SLOWO_NA_DZIS = "S³owo na dziœ: ";
    protected JLabel label;
    protected JButton losujButton;
    protected JButton zamknijButton;
    protected JButton styleButton;
    protected Panel buttonPanel;

    public MCKMWindow() {
        super();
        final String mckmWord;
        if (MCKMGenerator.settings.containsKey("slowo"))
            mckmWord = MCKMGenerator.settings.get("slowo");
        else
            mckmWord = MCKMUtils.getMCKMWord();

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        label = new JLabel(SLOWO_NA_DZIS + mckmWord);
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        losujButton = new JButton("Losuj");
        zamknijButton = new JButton("Zamknij");
        styleButton = new JButton("Zmieñ styl");

        buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(losujButton);
        buttonPanel.add(zamknijButton);
        buttonPanel.add(styleButton);

        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        addListeners();
    }

    public void addListeners() {
        losujButton.addActionListener(e -> {
                    String slowo = MCKMUtils.generateWord(0);
                    label.setText(SLOWO_NA_DZIS + slowo);
                    MCKMGenerator.settings.put("slowo", slowo);
                }
        );

        zamknijButton.addActionListener(e -> {
            Point p = MCKMWindow.this.getLocation();
            MCKMGenerator.settings.put("xpos", String.valueOf((int) p.getX()));
            MCKMGenerator.settings.put("ypos", String.valueOf((int) p.getY()));
            MCKMUtils.writeSettings(MCKMGenerator.settings);
            System.exit(0);
        });

        styleButton.addActionListener(e -> {
            Point p = MCKMWindow.this.getLocation();
            MCKMGenerator.settings.put("xpos", String.valueOf((int) p.getX()));
            MCKMGenerator.settings.put("ypos", String.valueOf((int) p.getY()));
            MCKMUtils.writeSettings(MCKMGenerator.settings);
            String style = MCKMGenerator.settings.get("style");
            if ("com.bulenkov.darcula.DarculaLaf".equals(style)) {
                style = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            } else {
                style = "com.bulenkov.darcula.DarculaLaf";
            }

            MCKMGenerator.settings.put("style", style);
            try {
                MCKMGenerator.restart();
            } catch (Exception ex) {
                ex.printStackTrace();
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
                Point p = MCKMWindow.this.getLocation();
                p.x += e.getXOnScreen() - mx;
                p.y += e.getYOnScreen() - my;
                mx = e.getXOnScreen();
                my = e.getYOnScreen();
                MCKMWindow.this.setLocation(p);
            }
        });
    }

}
