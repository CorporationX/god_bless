package faang.school.godbless.google_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebPageService {

    private static final Map<String, List<WebPage>> MAP = new HashMap<>();
    private static final Map<String, WebPage> WEB_PAGE_MAP = new HashMap<>();

    public void addNewPage(WebPage webPage) {
        for (String keyword : findAllKeyWordByWebPage(webPage)) {
            MAP.computeIfAbsent(keyword, k -> new ArrayList<>())
                    .add(webPage);
        }
        WEB_PAGE_MAP.put(webPage.getUrl(), webPage);
    }

    public List<WebPage> findAllWebPagesByKeyword(String keyword) {
        return MAP.get(keyword);
    }

    public void deleteWebPageByUrl(String url) {
        WebPage webPageForRemove = WEB_PAGE_MAP.remove(url);
        List<String> keywords = findAllKeyWordByWebPage(webPageForRemove);
        for (String keyword : keywords) {
            MAP.get(keyword).remove(webPageForRemove);
        }
    }

    private List<String> findAllKeyWordByWebPage(WebPage webPage) {
        List<String> result = new ArrayList<>();

        for (String word : webPage.getContent().split(" ")) {
            StringBuilder stringBuilder = new StringBuilder();
            // Небольшая проверка, чтобы убрать все лишние знаки
            for (Character character : word.toCharArray()) {
                if (Character.isAlphabetic(character)) {
                    stringBuilder.append(character);
                }
            }

            result.add(stringBuilder.toString());
        }

        return result;
    }
}