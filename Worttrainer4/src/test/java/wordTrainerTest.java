import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class WordTrainerTest {

    private WordTrainer wordTrainer;

    @BeforeEach
    void setUp() {
        wordTrainer = new WordTrainer();
    }

    @Test
    void testInitialListNotNull() {
        assertNotNull(wordTrainer.getList(), "Die Liste sollte initialisiert sein und nicht null.");
    }

    @Test
    void testInitialListSize() {
        assertEquals(6, wordTrainer.getList().size(), "Die Liste sollte genau 6 Elemente enthalten.");
    }

    @Test
    void testListContainsExpectedElements() {
        LinkedList<WordPair> list = wordTrainer.getList();

        assertEquals("TGM", list.get(0).getWord(), "Das erste Wortpaar sollte 'TGM' sein.");
        assertEquals("Flasche", list.get(1).getWord(), "Das zweite Wortpaar sollte 'Flasche' sein.");
        assertEquals("Hund", list.get(2).getWord(), "Das dritte Wortpaar sollte 'Hund' sein.");
        assertEquals("Auto", list.get(3).getWord(), "Das vierte Wortpaar sollte 'Auto' sein.");
        assertEquals("Katze", list.get(4).getWord(), "Das fünfte Wortpaar sollte 'Katze' sein.");
        assertEquals("Apfel", list.get(5).getWord(), "Das sechste Wortpaar sollte 'Apfel' sein.");
    }

    @Test
    void testGetAndSetAttempts() {
        wordTrainer.setAttempts(10);
        assertEquals(10, wordTrainer.getAttempts(), "Die Anzahl der Versuche sollte 10 sein.");
    }

    @Test
    void testGetAndSetCorrectCount() {
        wordTrainer.setCorrectCount(5);
        assertEquals(5, wordTrainer.getCorrectCount(), "Die Anzahl der korrekten Antworten sollte 5 sein.");
    }

    @Test
    void testGetAndSetFalseCount() {
        wordTrainer.setFalseCount(3);
        assertEquals(3, wordTrainer.getFalseCount(), "Die Anzahl der falschen Antworten sollte 3 sein.");
    }

    @Test
    void testSetList() {
        LinkedList<WordPair> newList = new LinkedList<>();
        newList.add(new WordPair("TestWort", "https://example.com/test.jpg"));

        wordTrainer.setList(newList);
        assertEquals(1, wordTrainer.getList().size(), "Die Liste sollte jetzt ein Element enthalten.");
        assertEquals("TestWort", wordTrainer.getList().get(0).getWord(), "Das erste Element sollte 'TestWort' sein.");
    }
}
