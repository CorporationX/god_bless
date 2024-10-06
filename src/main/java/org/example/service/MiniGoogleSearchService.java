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
    public static Map<String, List<WebPage>> webPagesByKeyWord = new HashMap<>(Map.of(
            "some", new ArrayList<>(Arrays.asList(new WebPage("http://sport.kz", "sport", "some content about sport"))),
            "content", new ArrayList<>(Arrays.asList(new WebPage("http://sport.kz", "sport", "some content about sport"))),
            "about", new ArrayList<>(Arrays.asList(new WebPage("http://sport.kz", "sport", "some content about sport"))),
            "sport", new ArrayList<>(Arrays.asList(new WebPage("http://sport.kz", "sport", "some content about sport"))),
            "ai", new ArrayList<>(Arrays.asList(new WebPage("medicine.kz", "AI in medicine", "AI in KZ medicine"))),
            "in", new ArrayList<>(Arrays.asList(new WebPage("medicine.kz", "AI in medicine", "AI in KZ medicine"))),
            "kz", new ArrayList<>(Arrays.asList(new WebPage("medicine.kz", "AI in medicine", "AI in KZ medicine"))),
            "medicine", new ArrayList<>(Arrays.asList(new WebPage("medicine.kz", "AI in medicine", "AI in KZ medicine")))
    ));
    private static Map<String, Set<String>> urlByKeyWords = new HashMap<>(Map.of(
            "http://sport.kz", Set.of("some", "content", "about", "sport"),
            "medicine.kz", Set.of("ai", "in", "kz", "medicine")
    ));

    public static void indexingWebPage(WebPage webPage) {
        if (!urlByKeyWords.containsKey(webPage.getUrl())) {
            Set<String> uniqueWordsCurrentWebPage = new HashSet<>(
                    Arrays.asList(webPage.getContent().toLowerCase().split(" "))
            );
            urlByKeyWords.computeIfAbsent(webPage.getUrl(), url -> new HashSet<>()).addAll(uniqueWordsCurrentWebPage);

            for (String uniqueWord : uniqueWordsCurrentWebPage) {
                webPagesByKeyWord.computeIfAbsent(uniqueWord, word -> new ArrayList<>()).add(webPage);
            }
        } else {
            throw new IllegalArgumentException("Web page by this " + webPage.getUrl() + " is already have");
        }
    }

    public static List<WebPage> searchWebPageByKeyWord(String keyword) {
        return MiniGoogleSearchService.webPagesByKeyWord.get(keyword);
    }

    public static void removeWebPageByUrl(String url) {
        Set<String> keyWordsOfRemovingWebPage = urlByKeyWords.remove(url);

        if(keyWordsOfRemovingWebPage != null){
            for (String keyWord : keyWordsOfRemovingWebPage) {
                webPagesByKeyWord.get(keyWord).removeIf(webPage -> {
                    if(webPage.getUrl().equals(url)){
                        return true;
                    }
                    return false;
                });
            }
        }else{
            throw new NullPointerException("we dont have such web page with this url: " + url);
        }
    }
}
