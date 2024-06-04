package faang.school.godbless.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Slf4j
@Data
@AllArgsConstructor
public class SearchEngine {

    Map<String, List<WebPage>> webPagesByKeyword;

    public void indexWebPage(WebPage webPage) {
        Objects.requireNonNull(webPage);
        if (webPage.content() != null) {
            Arrays.stream(webPage.content()
                            .split(" "))
                    .forEach(keyword -> webPagesByKeyword.computeIfAbsent(keyword, k -> new ArrayList<>()).add(webPage));
        } else {
            log.warn("No content to index for current webpage.");
        }
    }

    public List<WebPage> searchWebPages(String keyword) {
        return webPagesByKeyword.getOrDefault(keyword, Collections.emptyList());
    }

    public void deleteWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : webPagesByKeyword.entrySet()) {
            List<WebPage> pages = entry.getValue();
            pages.removeIf(page -> page.url().equalsIgnoreCase(url));
            if (pages.isEmpty()) {
                webPagesByKeyword.remove(entry.getKey());
            }
        }
    }
}
