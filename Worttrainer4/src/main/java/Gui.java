import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Gui extends JFrame {
    private JLabel imageLabel;
    private JTextField descriptionField;
    private JLabel resultLabel;
    private JLabel correctCounterLabel;
    private JLabel totalAttemptsLabel;

    private JLabel falseAttemtsLabel;

    public Gui() {
        setTitle("Worttrainer für Volksschueler");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Bild hinzufügen
        try {
            URL url = new URL("https://img.freepik.com/vektoren-kostenlos/gemuetliche-zeichentrickfilm-familienhaus-illustration_1308-164456.jpg");
            Image image = ImageIO.read(url);
            imageLabel = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
            imageLabel = new JLabel("Bild konnte nicht geladen werden.");
        }
        add(imageLabel, BorderLayout.CENTER);

        // Textfeld für die Beschreibung
        descriptionField = new JTextField();
        add(descriptionField, BorderLayout.NORTH);

        // Ergebnislabel
        resultLabel = new JLabel(" ");
        add(resultLabel, BorderLayout.SOUTH);

        // Counter Labels
        correctCounterLabel = new JLabel("Korrekte Beschreibungen: 0");
        totalAttemptsLabel = new JLabel("Gesamtversuche: 0");
        falseAttemtsLabel = new JLabel("Falsche Versuche: 0");
        JPanel counterPanel = new JPanel();
        counterPanel.setLayout(new GridLayout(3, 1));
        counterPanel.add(correctCounterLabel);
        counterPanel.add(totalAttemptsLabel);
        counterPanel.add(falseAttemtsLabel);
        add(counterPanel, BorderLayout.EAST);

        // Action Listener für das Textfeld
        descriptionField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                if (description.equalsIgnoreCase("richtige Beschreibung")) { // Hier die richtige Beschreibung einfügen
                    resultLabel.setText("Richtig!");
                } else {
                    resultLabel.setText("Falsch, versuche es erneut.");
                }

                descriptionField.setText("");
            }
        });
    }

}

