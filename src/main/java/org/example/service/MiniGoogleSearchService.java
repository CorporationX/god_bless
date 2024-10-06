package org.example.service;

import org.example.model.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MiniGoogleSearchService {
    private static List<WebPage> webPagesAboutSport = new ArrayList<>(Arrays.asList(
            new WebPage("http://sport.kz", "sport", "some content about sport"),
            new WebPage("http://newsSport.kz", "De Yong back to training", "some sport content about news"),
            new WebPage("http://sport_life.kz", "La liga table", "some sport content la liga table"),
            new WebPage("http://setanta_sport.kz", "Chanel plan for today", "some sport content about setanta"),
            new WebPage("http://qazsport.kz", "Qazaqstan sport is growing", "some content about sport in KZ")
    ));
    private static List<WebPage> webPagesAboutAI = new ArrayList<>(Arrays.asList(
            new WebPage("medicine.kz", "AI in medicine", "AI in KZ medicine"),
            new WebPage("medlife.kz", "AI in medicine", "AI in KZ medicine"),
            new WebPage("news.kz", "AI in medicine", "AI in KZ medicine"),
            new WebPage("AI.kz", "AI in medicine", "AI in KZ medicine")
    ));
    public static Map<String, List<WebPage>> webPagesByKeyWord = new HashMap<>(Map.of(
            "sport", webPagesAboutSport,
            "ai", webPagesAboutAI
    ));
    private static Map<String, String> urlsByKeyWord = new HashMap<>();

    public static void indexingWebPage(WebPage webPage) {
        String allContentOfWebPage = (webPage.getTitle() + " " + webPage.getContent())
                .toLowerCase();
        Set<String> uniqueWordsCurrentWebPage = new HashSet<>(Arrays.asList(allContentOfWebPage.split(" ")));

        for (String word : uniqueWordsCurrentWebPage) {
            if (webPagesByKeyWord.containsKey(word)) {
                urlsByKeyWord.put(word, webPage.getUrl());
                webPagesByKeyWord.get(word).add(webPage);
                break;
            }
        }
    }

    public static List<WebPage> searchWebPageByKeyWord(String keyword) {
        return MiniGoogleSearchService.webPagesByKeyWord.get(keyword);
    }

    public static void removeWebPageByUrl(String url) {
        String keyWordOfRemovingWebPage = urlsByKeyWord.remove(url);

        webPagesByKeyWord.computeIfPresent(keyWordOfRemovingWebPage, (keyWord, pages) -> {
            for (WebPage webPage : pages) {
                if (webPage.getUrl().equals(url)) {
                    pages.remove(webPage);
                    break;
                }
            }
            if (pages.isEmpty()) {
                return new ArrayList<>();
            }

            return pages;
        });
    }
}
