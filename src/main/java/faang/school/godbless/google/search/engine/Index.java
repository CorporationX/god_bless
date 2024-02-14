package faang.school.godbless.google.search.engine;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class Index {
    public List<WebPage> index = new ArrayList<>();

    public void addWebPageToIndex (WebPage webPage) {
        index.add(webPage);
    }

    public void removeWebPageFromIndexByUrl (String url) {
        List<WebPage> restrictedPages = new ArrayList<>();

        for (WebPage webPage : index) {
            if (webPage.getUrl().equals(url)) {
                restrictedPages.add(webPage);
            }
        }

        index.removeAll(restrictedPages);
    }

    public Map<String, List<WebPage>> getWebPagesIndexedByKeyword () {
        Map<String, List<WebPage>> webPagesIndexedList = new HashMap<>();

        for (WebPage webPage : index) {
            Set<String> keywords = getFormattedKeywords(webPage);

            for (String keyword : keywords) {
                webPagesIndexedList.putIfAbsent(keyword, new ArrayList<>());
                webPagesIndexedList.get(keyword).add(webPage);
            }
        }

        return webPagesIndexedList;
    }

    public List<WebPage> getIndexByKeyword (String keyword) {
        Map<String, List<WebPage>> webPagesIndexedList = getWebPagesIndexedByKeyword();
        keyword = getFormattedKeyword(keyword);

        return webPagesIndexedList.get(keyword);
    }

    private Set<String> getFormattedKeywords (WebPage webPage) {
        Set<String> keywords = new HashSet<>(List.of(webPage.getContent().split(" ")));
        Set<String> formattedKeywords = new HashSet<>();

        for (String keyword : keywords) {
            keyword = getFormattedKeyword(keyword);

            if (keyword.length() > 0) {
                formattedKeywords.add(keyword);
            }
        }

        return formattedKeywords;
    }

    private String getFormattedKeyword (String keyword) {
        String formattedKeyword = keyword
                .toLowerCase()
                .replace(",", "")
                .replace(".", "");

        return formattedKeyword;
    }
}
