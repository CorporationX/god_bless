package school.faang.googleMiniEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SearchEngine {
    private final Map<String, List<WebPage>> indexMap = new HashMap<>();

    public void addWebPageToIndex(WebPage page) {
        List<String> wordsArray = List.of(page.content().split(" "));

        for(String word: wordsArray) {
            indexMap.putIfAbsent(word, new ArrayList<>());
            List<WebPage> pagesList = indexMap.get(word);
            pagesList.add(page);
            // подумал о том, что в списке может быть несколько одинаковых WebPage, решил так от повторов избавиться
            // может есть вариант лучше?
            Set<WebPage> set = new HashSet<>(pagesList);
            pagesList.clear();
            pagesList.addAll(set);
        }
    }

    public void showSearchIndexContent() {
        for(var pages: indexMap.entrySet()) {
            System.out.println("Word: " + pages.getKey());
            System.out.println("Pages : ");

            for(WebPage page: pages.getValue()) {
                System.out.println(page.url());
            }

            System.out.println("-------------");
            System.out.println();
        }
    }

    public List<WebPage> returnWebPageListByKeyWord(String word) {
        return indexMap.get(word);
    }

    public void removeWebPageFromIndexByUrl(String url) {
        for(Map.Entry<String, List<WebPage>> entry: indexMap.entrySet()) {
            Iterator<WebPage> iterator = entry.getValue().iterator();

            while(iterator.hasNext()) {
                if(iterator.next().url().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }
}
