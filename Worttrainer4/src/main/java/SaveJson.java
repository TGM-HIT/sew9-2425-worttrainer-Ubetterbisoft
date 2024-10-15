import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SaveJson implements PersistanceStrategy{
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

    @Override
    public WordTrainer load() {

        // Laden als JSON
        Gson gson = new Gson();
        WordTrainer wordTrainer = null;

        File file = new File("file.json");
        if (file.length() == 0) {
            System.out.println("Die Datei ist leer. Es wird der default WordTrainer verwendet.");
        } else {
            System.out.println("Die Datei ist nicht leer. Der WordTrainer wird geladen.");
            try (FileReader reader = new FileReader("file.json")) {
                wordTrainer = gson.fromJson(reader, WordTrainer.class);
                return wordTrainer;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        wordTrainer = new WordTrainer();
        return wordTrainer;
    }
    public static void main(String[]args){
        new SaveJson().
        save(new WordTrainer());
    }
}
