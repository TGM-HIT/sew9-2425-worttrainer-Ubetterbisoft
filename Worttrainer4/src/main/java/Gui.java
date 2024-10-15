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
    private JLabel falseAttemptsLabel;

    public Gui() {

        setTitle("Worttrainer für Volksschueler");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        WordTrainer wordTrainer = new WordTrainer();

        // Zeigt das erste Bild an
        displayImage(wordTrainer);

        // Textfeld für die Beschreibung
        descriptionField = new JTextField();
        add(descriptionField, BorderLayout.NORTH);

        // Ergebnislabel
        resultLabel = new JLabel(" ");
        add(resultLabel, BorderLayout.SOUTH);

        // Counter Labels
        correctCounterLabel = new JLabel("Korrekte Beschreibungen: 0");
        totalAttemptsLabel = new JLabel("Gesamtversuche: 0");
        falseAttemptsLabel = new JLabel("Falsche Versuche: 0");
        JPanel counterPanel = new JPanel();
        counterPanel.setLayout(new GridLayout(3, 1));
        counterPanel.add(correctCounterLabel);
        counterPanel.add(totalAttemptsLabel);
        counterPanel.add(falseAttemptsLabel);
        add(counterPanel, BorderLayout.EAST);

        // Action Listener für das Textfeld
        descriptionField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                if(description.equals("")){
                    System.exit(0);
                }
                int correctCount = wordTrainer.getCorrectCount();
                int falseCount = wordTrainer.getFalseCount();

                String correctDescription = wordTrainer.getList().get(correctCount).getWord(); // Angenommene Methode für die richtige Beschreibung


                if (description.equalsIgnoreCase(correctDescription)) {

                    resultLabel.setText("Richtig!");
                    wordTrainer.setCorrectCount(wordTrainer.getCorrectCount()+1);
                    correctCount++;
                    if (correctCount < wordTrainer.getList().size()) {
                        displayImage(wordTrainer);
                    } else {
                        resultLabel.setText("Keine weiteren Bilder.");

                    }

                } else {
                    resultLabel.setText("Falsch, versuche es erneut.");
                    wordTrainer.setFalseCount(wordTrainer.getFalseCount()+1);

                }

                wordTrainer.setAttempts(wordTrainer.getFalseCount()+wordTrainer.getCorrectCount());

                totalAttemptsLabel.setText("Gesamtversuche: " + (wordTrainer.getFalseCount()+wordTrainer.getCorrectCount()));
                correctCounterLabel.setText("Korrekte Beschreibungen: " + wordTrainer.getCorrectCount());
                falseAttemptsLabel.setText("Falsche Versuche: " + wordTrainer.getFalseCount());

                // Nächstes Bild anzeigen




                descriptionField.setText("");
            }
        });
    }

    private void displayImage(WordTrainer wordTrainer) {
        try {

            // Entferne das alte Bild, falls vorhanden
            if (imageLabel != null) {
                remove(imageLabel);
            }
            int correctCount = wordTrainer.getCorrectCount();

            URL url = new URL(wordTrainer.getList().get(correctCount).getUrl());

            Image image = ImageIO.read(url);
            imageLabel = new JLabel(new ImageIcon(image));
            add(imageLabel, BorderLayout.CENTER);
            revalidate(); // Layout aktualisieren
            repaint(); // GUI neu zeichnen
        } catch (IOException e) {
            e.printStackTrace();
            imageLabel = new JLabel("Bild konnte nicht geladen werden.");
            add(imageLabel, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }
}
