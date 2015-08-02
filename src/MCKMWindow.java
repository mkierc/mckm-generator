import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.Date;

public class MCKMWindow extends JWindow {
    private static final String SLOWO_NA_DZIS = "S³owo na dziœ: ";
    private JLabel label;
    private JButton losujButton;
    private JButton zamknijButton;
    private Panel buttonPanel;

    public MCKMWindow() {
        super();
        final String mckmWord = MCKMFactory.getMCKMWord();

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        label = new JLabel(SLOWO_NA_DZIS + mckmWord);
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        losujButton = new JButton("Losuj");
        zamknijButton = new JButton("Zamknij");
        buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(losujButton);
        buttonPanel.add(zamknijButton);

        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        addListeners();


    }

    public void addListeners() {
        losujButton.addActionListener(e -> label.setText(SLOWO_NA_DZIS + MCKMFactory.generateWord(0)));

        zamknijButton.addActionListener(e -> System.exit(0));

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
