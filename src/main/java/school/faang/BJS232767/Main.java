package school.faang.BJS232767;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<WebPage>> webPageMap = new HashMap<>();

    static void addPage(WebPage page) {
        String[] words = page.getContent().split("\\W+");
        for (String word : words) {
            webPageMap.computeIfAbsent(word.toLowerCase(), w -> new ArrayList<>()).add(page);
        }
    }

    static List<WebPage> getWebPagesByKeyWord(String keyWord) {
        String key = keyWord.toLowerCase();
        return webPageMap.get(key);
    }

    static void deleteWebPageByURL(String url) {
        List<String> keysToDelete = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()) {
            List<WebPage> webPages = entry.getValue();
            webPages.removeIf(page -> page.getUrl().equals(url));
            if (webPages.isEmpty()) {
                keysToDelete.add(entry.getKey());
            }
        }
        for (String key : keysToDelete) {
            webPageMap.remove(key);
        }
    }

    public static void main(String[] args) {
        List<WebPage> pages = List.of(
                new WebPage("https://kaspi.kz", "Kaspi.kz", "Super application in Kazakhstan!"),
                new WebPage("https://satu.kz", "Satu", "The website where you could place your..."),
                new WebPage("https://olx.kz", "OLX", "The bazaar of different ads"),
                new WebPage("https://flip.kz", "Flip.kz", "The Book marketplace")
        );

        for (WebPage page : pages) {
            addPage(page);
        }
        System.out.println(getWebPagesByKeyWord("BOOK"));
        deleteWebPageByURL("https://flip.kz");
    }
}
