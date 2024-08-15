package faang.school.godbless.SearchPageByIndexes;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Getter
@Setter
public class Main {
    private Map<String, Set<WebPage>> pagesKeyIndexes = new HashMap<>();
    private Map<String, WebPage> allPagesURL = new HashMap<>();

    public static void main(String[] args) {

    }


    public void registrationPageIndexes(@NonNull WebPage webPage) {
        createURLForPage(webPage);
        String[] keyWords = webPage.getContent().split(" ", -1);
        for (String keyWord : keyWords) {
            String cleanKeyWord = cleanKeyWord(keyWord);
            if (!keyWord.isBlank()) {
                pagesKeyIndexes.computeIfAbsent(cleanKeyWord, key -> new HashSet<>()).add(webPage);
            }
        }
    }

    public Set<WebPage> searchPagesByKeyWord(@NonNull String keyWord) {
        String cleanKeyWord = cleanKeyWord(keyWord);
        return pagesKeyIndexes.getOrDefault(cleanKeyWord, Collections.emptySet());
    }


    public void deletePageFromKeyIndexes(String url) {
        Optional<WebPage> optionalWebPage = findByURL(url);

        if (optionalWebPage.isPresent()) {
            WebPage deletedWebPage = optionalWebPage.get();
            deletePageByURL(url);

            for (Map.Entry<String, Set<WebPage>> entry : pagesKeyIndexes.entrySet()) {
                entry.getValue().remove(deletedWebPage);
            }
        } else {
            System.out.println("Page with URL " + url + " not found.");
        }
    }

    public Optional<WebPage> findByURL(String url) {
        return Optional.ofNullable(allPagesURL.get(url));
    }

    public void createURLForPage(WebPage webPage) {
        allPagesURL.put(webPage.getUrl(), webPage);
    }

    public void deletePageByURL(String url) {
        allPagesURL.remove(url);
    }

    public String cleanKeyWord(String keyWord) {
        return keyWord.replaceAll("\\p{Punct}", "");
    }
}
