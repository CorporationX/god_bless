package school.faang.googleEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> wordsMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage ozon = new WebPage("https://ozon.com", "Ozon", "A marketplace where you can buy...");
        WebPage wildberries = new WebPage("https://wb.com", "WildBerries", "Another marketplace in which you may buy...");
        WebPage discord = new WebPage("https://discord.com", "Discord", "Chat, play, stream...");

        addPage(ozon);
        addPage(wildberries);
        addPage(discord);
        printAllInfo();
        System.out.println(findByKeyword("marketplace"));
        removePage("https://wb.com");
        printAllInfo();
    }

    private static void addPage(WebPage page) {
        String[] words = page.getContent().split("[ ,.!?-]+");
        for (String word : words) {
            wordsMap.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
        }
    }

    private static void removePage(String url) {
        List<String> keysToRemove = new ArrayList<>();
        for (var entry : wordsMap.entrySet()) {
            List<WebPage> pages = entry.getValue();
            pages.removeIf(webPage -> webPage.getUrl().equals(url));
            if (pages.isEmpty()) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (String key : keysToRemove) {
            wordsMap.remove(key);
        }
    }

    private static List<WebPage> findByKeyword(String keyword) {
        return wordsMap.get(keyword);
    }

    private static void printAllInfo() {
        System.out.println(wordsMap);
    }
}
