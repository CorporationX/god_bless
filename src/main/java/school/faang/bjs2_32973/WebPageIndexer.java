package school.faang.bjs2_32973;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class WebPageIndexer {


    public void indexWebPage(WebPage webPage, Map<String, List<WebPage>> webPageKeywordIndex) {
        if (webPage == null) {
            throw new IllegalArgumentException("web page is null");
        }
        if (webPageKeywordIndex == null) {
            throw new IllegalArgumentException("webPageKeywordIndex is null");
        }
        String content = webPage.getContent();

        String[] contentWords = divideByWords(content);

        for (String contentWord : contentWords) {
            String contentWordLowerCase = contentWord.toLowerCase();

            if (!(webPageKeywordIndex.containsKey(contentWordLowerCase))) {
                List<WebPage> webPagesToWord = new ArrayList<>();
                webPagesToWord.add(webPage);
                webPageKeywordIndex.put(contentWordLowerCase, webPagesToWord);
            } else {
                List<WebPage> webPages = webPageKeywordIndex.get(contentWordLowerCase);
                if (!(webPages.contains(webPage))) {
                    webPages.add(webPage);
                }

            }
        }
    }

    private static String[] divideByWords(String content) {
        if (content == null || content.isEmpty() || content.isBlank()) {
            throw new NullPointerException("сontent is empty");
        }
        String nonLetterOrDigitRegex = "[^\\p{L}\\p{N}']+";
        return content.split(nonLetterOrDigitRegex);
    }

    public List<WebPage> getWebPagesByWord(String keyWord, Map<String, List<WebPage>> webPageKeywordIndex) {
        if(webPageKeywordIndex == null){
            throw new IllegalArgumentException("webPageKeywordIndex is null");
        }
        String contentWordLowerCase = keyWord.toLowerCase();
        return webPageKeywordIndex.get(contentWordLowerCase);
    }

    public void removeFromIndexByUrl(String urlForRemove, Map<String, List<WebPage>> webPageKeywordIndex) {
        if(webPageKeywordIndex == null){
            throw new IllegalArgumentException("webPageKeywordIndex is null");
        }
        String[] keyWordsWebPageToRemove = getKeyWordsCurrentWebPageByUrl(urlForRemove, webPageKeywordIndex);
        if (keyWordsWebPageToRemove == null) {
            throw new NoSuchElementException("there is no web page with this url in the index");
        }
        for (String keyWordForWebPageToRemove : keyWordsWebPageToRemove) {
            List<WebPage> webPages = getWebPagesByWord(keyWordForWebPageToRemove, webPageKeywordIndex);

            for (WebPage webPage : webPages) {
                String urlCurrentWebPage = webPage.getUrl();

                if (Objects.equals(urlCurrentWebPage, urlForRemove)) {
                    webPages.remove(webPage);

                    if (webPages.isEmpty()) {
                        webPageKeywordIndex.remove(keyWordForWebPageToRemove);
                    }
                    break;
                }
            }
        }
    }

    private static String[] getKeyWordsCurrentWebPageByUrl(String urlForRemove, Map<String, List<WebPage>> webPageKeywordIndex) {
        for (Map.Entry<String, List<WebPage>> stringListEntry : webPageKeywordIndex.entrySet()) {
            List<WebPage> webPages = stringListEntry.getValue();
            for (WebPage webPage : webPages) {
                String urlCurrentWebPage = webPage.getUrl();
                if (Objects.equals(urlCurrentWebPage, urlForRemove)) {
                    String contentCurrentWebPage = webPage.getContent();
                    return divideByWords(contentCurrentWebPage);
                }
            }
        }
        return null;
    }
}
