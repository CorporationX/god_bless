package faang.school.godbless.hashMap;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, List<WebPage>> researchMap = new HashMap<>();

        addWebPage(researchMap, new WebPage("https://faang-school.com", "HashMap", "There, is content about hashMap"));
        addWebPage(researchMap, new WebPage("https://school.com", "TreeMap", "Page about TreeMap!"));
        addWebPage(researchMap, new WebPage("https://faang.com", "Set", "..On this page you can read about set"));

        deleteWebPageByURL(researchMap, "https://school.com");

        System.out.println(findWebPageByKeyword(researchMap, "about"));

    }

    public static void addWebPage(Map<String, List<WebPage>> researchMap, @NonNull WebPage webPage) {
        Arrays.stream(webPage.getContent().replaceAll("\\p{P}", "").split(" "))
                .map(String::toLowerCase)
                .distinct()
                .forEach(word -> researchMap.computeIfAbsent(word, v -> new ArrayList<>()).add(webPage));
    }

    public static List<WebPage> findWebPageByKeyword(Map<String, List<WebPage>> researchMap, @NonNull String keyword) {
        return researchMap.get(keyword);
    }

    public static void deleteWebPageByURL(Map<String, List<WebPage>> researchMap, @NonNull String url) {
        for (Map.Entry<String, List<WebPage>> entry : researchMap.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
