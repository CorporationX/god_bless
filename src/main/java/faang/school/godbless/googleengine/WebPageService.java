package faang.school.godbless.googleengine;

import java.util.*;

public class WebPageService {

    private static final Map<String, List<WebPage>> listOfWebPages = new HashMap<>();
    private static final String FILTER = "[^a-zA-Zа-яА-ЯёЁ ]";

    public Map<String, List<WebPage>> createIndex(WebPage webPage) {
        List<String> words = List.of(webPage.getContent().replaceAll(FILTER, "").split(" +"));

        for (String word : words) {
            listOfWebPages.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }

        return listOfWebPages;
    }

    public List<WebPage> findPageByWord(String string) {
        return listOfWebPages.get(string);
    }

    public void removeWebPageByURL(String url) {
        for (Map.Entry<String, List<WebPage>> entry : listOfWebPages.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

}
