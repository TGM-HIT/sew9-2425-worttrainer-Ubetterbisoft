import java.net.HttpURLConnection;
import java.net.URL;

public class WordPair {
    private String word;
    private String url;

    public WordPair(String word,String url){
        this.word = word;
        this.url = url;
    }
    public WordPair(){
        this.url = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG/280px-Brigittenau_%28Wien%29_-_TGM-Hauptgeb%C3%A4ude.JPG";
        this.word="TGM";
    }

    /**
     * checks the url atributes validity
     * it sends a request and waits for the response code
     * @return validity status of the url
     */
    public boolean checkURL(){
        try {
            URL url = new URL(this.url);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            int responseCode = huc.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }

    public String toString(){

        return this.word+" "+this.url;
    }


}
