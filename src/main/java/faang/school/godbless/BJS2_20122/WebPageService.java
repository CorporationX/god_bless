package faang.school.godbless.BJS2_20122;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebPageService {
    final Map<String, List<WebPage>> pages;
    final Set<WebPage> allPages = new HashSet<>();

    public WebPageService(Map<String, List<WebPage>> pages) {
        this.pages = pages;
    }

    public void addPage(WebPage page) {
        if (allPages.contains(page)) {
            throw new IllegalArgumentException("Page already added");
        }
        allPages.add(page);
        String[] text = page.getContent().replaceAll("[^a-zA-Z\\s]", "").split(" ");

        for (String word : text) {
            if (pages.containsKey(word)) {
                pages.get(word).add(page);
            } else {
                List<WebPage> newPages = new ArrayList<>();
                newPages.add(page);
                pages.put(word, newPages);
            }
        }
    }

    public List<WebPage> getPagesByWord(String word) {
        return pages.get(word);
    }

    public void removePage(String url) {
        allPages.removeIf(webPage -> webPage.getUrl().equals(url));
        for (Map.Entry<String, List<WebPage>> entry : pages.entrySet()) {
            List<WebPage> pageList = entry.getValue();
            pageList.removeIf(page -> page.getUrl().equals(url));
        }
    }
}
