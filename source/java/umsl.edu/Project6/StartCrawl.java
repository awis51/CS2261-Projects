package umsl.edu.Project6;

import java.util.Scanner;

public class StartCrawl {
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a Wikipedia URL: ");
            String url = input.nextLine();
            if(!url.contains("en.wikipedia.org")){
                System.out.println("Enter Wikipedia url only :");
                url = input.nextLine();
            }
            WebCrawler crawl = new WebCrawler();
            crawl.crawler(url);

        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
            System.out.println("Run program again!");
        }
    }
}
