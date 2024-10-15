import java.util.LinkedList;

public class WordTrainer {


    private LinkedList<WordPair> list;
    private int numAskedQ;
    private int correctQ;

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getFalseCount() {
        return falseCount;
    }

    public void setFalseCount(int falseCount) {
        this.falseCount = falseCount;
    }

    private int attempts;
    private int correctCount;
    private int falseCount;

    WordTrainer(){
        numAskedQ = 0;
        correctQ=0;
        this.list = new LinkedList<WordPair>();
        this.list.add(new WordPair("TGM","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG/280px-Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG"));
        this.list.add(new WordPair("Flasche","https://www.nanu-nana.at/media/catalog/product/cache/28b69c73e7edb2653ec17a1a5281398a/2/0/2000192000640_01_O_838606.jpg"));
        this.list.add(new WordPair("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ12Tyj23PZ_LjOfmaF_yBMiKftEZZ5puwypA&s"));
        this.list.add(new WordPair("Auto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz5BM2Y9-YkF_ibYBafayY-NjKaxKOuOKqkA&s"));
        this.list.add(new WordPair("Katze", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/320px-Cat03.jpg"));
        this.list.add(new WordPair("Apfel", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/320px-Red_Apple.jpg"));

        this.attempts = 0;
        this.correctCount= 0;
        this.falseCount= 0;



    }
    public LinkedList<WordPair> getList() {
        return list;
    }

    public void setList(LinkedList<WordPair> list) {
        this.list = list;
    }




    public String stats(){
        return "Asked Questions: "+ this.numAskedQ+"\nCorrect Questions: "+this.correctQ;
    }

}
