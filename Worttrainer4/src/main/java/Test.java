import java.util.LinkedList;
public class Test {
    public static void main(String[]args){
        LinkedList<WordPair> wordList = new LinkedList<>();
        wordList.add(new WordPair("vogel","https://www.lbv.de/files/user_upload/Bilder/Arten/Tiere/Vogel%20von%20A-Z/Singvogel/Blaumeise/Blaumeise_Parus_caeruleus_Willi-Kroll_LBV-frei_Portraet.jpg"));
        System.out.println(wordList);
        WordPair affe = new WordPair("affe","https://th.bing.com/th/id/OIP.CzLbCJ3jBeiNRJ1hPyeG2gHaHP?w=186&h=182&c=7&r=0&o=5&pid=1");

        System.out.println(affe.checkURL());
    }
}
