package faang.school.godbless.javaHashMap.searcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class WebPageService {
    private final Map<String, List<WebPage>> index;

    public WebPageService() {
        index = new HashMap<>();
    }


    public void indexWebPage(WebPage webPage) {
        List<String> keyWords = Arrays.stream(webPage.getContent().split("[\\s.,?!:;]+")).toList();

        for (String currentKeyWord : keyWords) {
            currentKeyWord = currentKeyWord.toLowerCase(Locale.ROOT);

            List<WebPage> currentPageList = index.computeIfAbsent(currentKeyWord, key -> new ArrayList<>());

            if (currentPageList.contains(webPage)) {
                continue;
            }

            currentPageList.add(webPage);
        }
    }

    public List<WebPage> search(String keyWord) {
        keyWord = keyWord.toLowerCase(Locale.ROOT);

        return index.get(keyWord);
    }

    public Optional<WebPage> getPageByUrl(String url) {
        if(url == null || url.isBlank()) {
            return Optional.empty();
        }

        for (List<WebPage> currentPageList : index.values()) {
            for (WebPage currentWebPage : currentPageList) {
                if (currentWebPage.getUrl().equals(url)) {
                    return Optional.of(currentWebPage);
                }
            }
        }

        return Optional.empty();
    }

    public boolean removePage(String url) {
        var pageToBeRemoved = getPageByUrl(url);

        if (pageToBeRemoved.isEmpty()) {
            return false;
        }

        for (List<WebPage> currentPageList : index.values()) {
            currentPageList.remove(pageToBeRemoved.get());
        }

        return true;
    }

    public void printIndex() {
        index.forEach((keyWord, webPages) -> {
            System.out.println("Stored pages for key word \"" + keyWord + "\":");

            webPages.forEach(System.out::println);
            System.out.println();
        });
    }
}
