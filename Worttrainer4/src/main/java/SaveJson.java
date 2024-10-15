import com.google.gson.Gson;

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
    public void load() {
        // Laden als JSON
    }
    public static void main(String[]args){
        new SaveJson().
        save(new WordTrainer());
    }
}
