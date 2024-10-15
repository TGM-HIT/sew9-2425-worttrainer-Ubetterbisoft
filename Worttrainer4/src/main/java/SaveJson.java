import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SaveJson implements PersistanceStrategy{
    /**
     * Speichert den WordTrainer als JSON
     * @param wordTrainer
     */
    @Override
    public void save(WordTrainer wordTrainer) {
        // Speichern als JSON
        Gson gson = new Gson();

        String json = gson.toJson(wordTrainer);
        System.out.println(json);
        try(FileWriter file = new FileWriter("file.json")) {
            file.write(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Lädt den WordTrainer aus dem Json ffile
     * @return
     */
    @Override
    public WordTrainer load() {

        // Laden als JSON
        Gson gson = new Gson();
        WordTrainer wordTrainer = null;

        File file = new File("file.json");

        /**
         * Überprüft ob die Datei leer ist, wenn ja soll der default WordTrainer verwendet werden
         */
        if (file.length() == 0) {
            System.out.println("Die Datei ist leer. Es wird der default WordTrainer verwendet.");
        } else {
            // Wenn die Datei nicht leer ist, wird der WordTrainer geladen
            System.out.println("Die Datei ist nicht leer. Der WordTrainer wird geladen.");
            try (FileReader reader = new FileReader("file.json")) {
                wordTrainer = gson.fromJson(reader, WordTrainer.class);
                //geladener Worttrainer
                return wordTrainer;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //default WordTrainer
        wordTrainer = new WordTrainer();
        return wordTrainer;
    }

}
