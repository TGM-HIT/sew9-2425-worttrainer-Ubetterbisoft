import java.util.LinkedList;

public class WordTrainer {


    private LinkedList<WordPair> list;
    private int numAskedQ;
    private int correctQ;

    WordTrainer(){
        numAskedQ = 0;
        correctQ=0;
        this.list = new LinkedList<WordPair>();
        this.list.add(new WordPair("TGM","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG/280px-Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG"));
        this.list.add(new WordPair("Flasche","https://www.nanu-nana.at/media/catalog/product/cache/28b69c73e7edb2653ec17a1a5281398a/2/0/2000192000640_01_O_838606.jpg"));

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
