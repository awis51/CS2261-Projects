package umsl.edu.Project6;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

public class WebCrawler {
    private Document htmlDocument;
    private final ArrayList<String> listOfWordSearch = new ArrayList<>();

    public static void main(String[] args){}

    public void crawler(String startingURL){
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);
        while(!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 1000) {
            String urlString = listOfPendingURLs.remove(0);
            if(!listOfTraversedURLs.contains(urlString)){
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl "+ urlString);

                for (String s : getSubUrls(urlString)){
                    if(!listOfTraversedURLs.contains(s))
                        if(s.contains("https://en.wikipedia.org"))
                            listOfPendingURLs.add(s);
                }
            } searchWords();
        }
        //the count occurrence of words occurs here so that it counts all words collected from every site.
        while(listOfWordSearch.size() !=0){
            String word = listOfWordSearch.get(0);
            int frequency = Collections.frequency(listOfWordSearch, word);
            listOfWordSearch.removeAll(Collections.singleton(word));
            System.out.println(word + " " + frequency);
        }
    }
    public ArrayList<String> getSubUrls(String urlString){
        ArrayList<String> list = new ArrayList<>();

        try{
            Document htmlDocument = Jsoup.connect(urlString).get();
            this.htmlDocument = htmlDocument;
            Elements linksOnPage = htmlDocument.select("a[href]");
            for(Element link: linksOnPage){
                list.add(link.absUrl("href"));
            }
            Thread.sleep(50);
        }catch (Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return list;
    }
    public void searchWords(){
        Element content = htmlDocument.getElementById("bodyContent");
        assert content != null;
        Elements wordsOnPage = content.getElementsByTag("p");
        String[] words = wordsOnPage.select("a,i,sup,span,code,pre,span1,ref").remove().text().split(" ");
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        listOfWordSearch.addAll(wordList);
    }
}
