package faang.school.godbless.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Data
@AllArgsConstructor
public class SearchEngine {

    Map<String, List<WebPage>> webPagesByKeyword;

    public void indexWebPage(WebPage webPage) {
        Objects.requireNonNull(webPage);
        if (webPage.content() != null) {
            Arrays.stream(webPage.content().toLowerCase()
                            .split("\\W+"))
                    .forEach(keyword -> webPagesByKeyword.computeIfAbsent(keyword, k -> new ArrayList<>()).add(webPage));
        } else {
            log.warn("No content to index for current webpage.");
        }
    }

    public List<WebPage> searchWebPages(String keyword) {
        return webPagesByKeyword.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }

    public void deleteWebPage(String url) {
        Iterator<Map.Entry<String, List<WebPage>>> iterator = webPagesByKeyword.entrySet().iterator();
        while (iterator.hasNext()) {
            List<WebPage> pages = iterator.next().getValue();
            pages.removeIf(page -> page.url().equalsIgnoreCase(url));
            if (pages.isEmpty()) {
                iterator.remove();
            }
        }
    }
}
