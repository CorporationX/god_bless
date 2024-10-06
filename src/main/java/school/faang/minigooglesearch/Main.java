package school.faang.minigooglesearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WebPageService service = new WebPageService();
        Map<String, List<WebPage>> urls = getURLs();

        WebPage page = new WebPage("https://techwebsite.com/article1", "Tech Article 1", "Content of tech article 3.");

        service.addWebPage(page, urls);

        for (Map.Entry<String, List<WebPage>> entry : urls.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Obj: " + entry.getValue());
        }

        System.out.println(service.findWebPages("technology", urls));

        service.removeWebPageByUrl(page, urls);
        System.out.println("-------------------------------------------");

        // print updated data
        for (Map.Entry<String, List<WebPage>> entry : urls.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Obj: " + entry.getValue());
        }
    }

    public static Map<String, List<WebPage>> getURLs(){
        Map<String, List<WebPage>> urls = new HashMap<>();
        List<WebPage> techPages = new ArrayList<>();

        techPages.add(new WebPage("https://techwebsite.com/article1", "Tech Article 1", "Content of tech article 1."));
        techPages.add(new WebPage("https://techwebsite.com/article2", "Tech Article 2", "Content of tech article 2."));

        urls.put("technology", techPages);

        return urls;
    }
}
