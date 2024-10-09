package faang.school.godbless.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    private final HashMap<String, List<WebPage>> index = new HashMap<>();

    public void addWebPage(WebPage webPage) {
        for (var w : splitContent(webPage.getContent())) {
            addWebPageByWord(w, webPage);
        }
    }

    public List<WebPage> findByWord(String word) {
        return Collections.unmodifiableList(index.get(word));
    }

    public void removeWebPageByUrl(String url) {
        index.forEach((key, value) -> value.removeIf(p -> url.equals(p.getUrl())));
    }

    public void printPages() {
        var sb = new StringBuilder();
        index.forEach((k, v) -> sb.append(String.format("%s: %s%n", k,
                v.stream().map(WebPage::getUrl).collect(Collectors.joining(","))))
        );
        System.out.println(sb.append("---"));
    }

    private void addWebPageByWord(String word, WebPage webPage) {
        index.computeIfAbsent(word, e -> new ArrayList<>()).add(webPage);
    }

    private String[] splitContent(String content) {
        return content.split("\\W+");
    }

}
