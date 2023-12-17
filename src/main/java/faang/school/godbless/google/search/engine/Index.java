package faang.school.godbless.google.search.engine;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Index {
    public Map<String, List<WebPage>> webPagesIndexedList = new HashMap<>();
    public List<WebPage> index = new ArrayList<>();
    public List<WebPage> restrictedWebPages = new ArrayList<>();

    public Map<String, List<WebPage>> addWebPageToIndex (WebPage webPage) {
        Set<String> keywords = getFormattedKeywords(webPage);

        if (restrictedWebPages.contains(webPage)) {
            return this.getWebPagesIndexedList();
        }

        for (String keyword : keywords) {
            getWebPagesIndexedList().putIfAbsent(keyword, new ArrayList<>());
            getWebPagesIndexedList().get(keyword).add(webPage);
        }

        return this.getWebPagesIndexedList();
    }

    public List<WebPage> getIndexByKeyword (String keyword) {
        keyword = getFormattedKeyword(keyword);

        return getWebPagesIndexedList().get(keyword);
    }

    public void removeWebPageFromIndexByUrl(String url) {
        for (WebPage webPage : index) {
            if (webPage.getUrl().equals(url)) {
                index.remove(webPage);
                restrictedWebPages.add(webPage);
            }
        }
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
