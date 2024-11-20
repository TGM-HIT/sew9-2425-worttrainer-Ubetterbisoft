import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static org.junit.jupiter.api.Assertions.*;

class SaveJsonTest {

    private SaveJson saveJson;
    private WordTrainer wordTrainer;
    private File testFile;

    @BeforeEach
    void setUp() {
        saveJson = new SaveJson();
        wordTrainer = new WordTrainer();  // Hier könnte man ggf. ein spezifisch befülltes WordTrainer-Objekt erstellen
        testFile = new File("file.json"); // Datei für die Speicherung
    }

    @AfterEach
    void tearDown() {
        // Testdatei nach jedem Test entfernen
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testSaveCreatesFile() {
        assertTrue(saveJson.save(wordTrainer), "Die save-Methode sollte true zurückgeben.");
        assertTrue(testFile.exists(), "Die Datei 'file.json' sollte nach dem Speichern existieren.");
    }

    @Test
    void testSaveFileContent() {
        saveJson.save(wordTrainer);

        try (FileReader fileReader = new FileReader("file.json")) {
            WordTrainer loadedTrainer = new Gson().fromJson(fileReader, WordTrainer.class);

            assertEquals(wordTrainer.getCorrectCount(), loadedTrainer.getCorrectCount(), "Die Anzahl der korrekten Antworten sollte übereinstimmen.");
            assertEquals(wordTrainer.getFalseCount(), loadedTrainer.getFalseCount(), "Die Anzahl der falschen Antworten sollte übereinstimmen.");
            assertEquals(wordTrainer.getList().size(), loadedTrainer.getList().size(), "Die Anzahl der Wortpaare sollte übereinstimmen.");
        } catch (Exception e) {
            fail("Es sollte keine Ausnahme auftreten: " + e.getMessage());
        }
    }

    @Test
    void testLoadReturnsDefaultIfFileIsEmpty() {
        try (FileWriter writer = new FileWriter("file.json")) {
            writer.write(""); // Leere Datei erstellen
        } catch (Exception e) {
            fail("Fehler beim Schreiben der leeren Datei.");
        }

        WordTrainer loadedTrainer = saveJson.load();
        assertEquals(6, loadedTrainer.getList().size(), "Der Standard-WordTrainer sollte 6 Wortpaare enthalten.");
        assertEquals("TGM", loadedTrainer.getList().get(0).getWord(), "Das erste Wort sollte 'TGM' sein.");
    }

    @Test
    void testLoadReturnsSavedWordTrainer() {
        saveJson.save(wordTrainer);  // Erst speichern

        WordTrainer loadedTrainer = saveJson.load();  // Dann laden
        assertNotNull(loadedTrainer, "Der geladene WordTrainer sollte nicht null sein.");
        assertEquals(wordTrainer.getCorrectCount(), loadedTrainer.getCorrectCount(), "Die Anzahl der korrekten Antworten sollte übereinstimmen.");
        assertEquals(wordTrainer.getFalseCount(), loadedTrainer.getFalseCount(), "Die Anzahl der falschen Antworten sollte übereinstimmen.");
    }


}
