import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordPairTest {

    private WordPair wordPair;

    @BeforeEach
    void setUp() {
        wordPair = new WordPair("Hund", "https://example.com/image.jpg");
    }

    @Test
    void testDefaultConstructor() {
        WordPair defaultWordPair = new WordPair();

        assertEquals("TGM", defaultWordPair.getWord(), "Das Standard-Wort sollte 'TGM' sein.");
        assertEquals(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG/280px-Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG",
                defaultWordPair.getUrl(),
                "Die Standard-URL sollte korrekt sein."
        );
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Hund", wordPair.getWord(), "Das Wort sollte 'Hund' sein.");
        assertEquals("https://example.com/image.jpg", wordPair.getUrl(), "Die URL sollte 'https://example.com/image.jpg' sein.");
    }

    @Test
    void testGetAndSetWord() {
        wordPair.setWord("Katze");
        assertEquals("Katze", wordPair.getWord(), "Das Wort sollte auf 'Katze' gesetzt sein.");
    }

    @Test
    void testGetAndSetUrl() {
        wordPair.setUrl("https://example.com/katze.jpg");
        assertEquals("https://example.com/katze.jpg", wordPair.getUrl(), "Die URL sollte auf 'https://example.com/katze.jpg' gesetzt sein.");
    }

    @Test
    void testToString() {
        String expected = "Hund https://example.com/image.jpg";
        assertEquals(expected, wordPair.toString(), "Die toString-Ausgabe sollte 'Hund https://example.com/image.jpg' sein.");
    }

    @Test
    void testCheckURLValid() {
        // Verwende hier eine echte und erreichbare URL, z.B. eine der Standard-URLs in WordPair
        wordPair.setUrl("https://www.google.com");

        assertTrue(wordPair.checkURL(), "Die Methode checkURL sollte für eine gültige URL true zurückgeben.");
    }

    @Test
    void testCheckURLInvalid() {
        // Verwende eine ungültige URL
        wordPair.setUrl("https://diese-url-existiert-nicht.com");

        assertFalse(wordPair.checkURL(), "Die Methode checkURL sollte für eine ungültige URL false zurückgeben.");
    }
}
