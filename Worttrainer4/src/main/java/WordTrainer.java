import java.util.LinkedList;

public class WordTrainer {
    private LinkedList<WordPair>;
    private int numAskedQ;
    private int correctQ;

    WordTrainer(){
        numAskedQ = 0;
        correctQ=0;
    }

    /**
     * Saves the progress in an external file
     */
    public void save(){

    }

    /**
     * loads the progress in an external file
     */
    public void load(){

    }

    public String stats(){
        return "Asked Questions: "+ this.numAskedQ+"\nCorrect Questions: "+this.correctQ;
    }

}
