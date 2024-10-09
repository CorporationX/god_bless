package school.faang.bjs2_32973;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebPageIndexer {


    public void indexWebPage(WebPage webPage, Map<String, List<WebPage>> webPageKeywordIndex){
        String content = webPage.getContent();

        String nonLetterOrDigitRegex = "[^\\p{L}\\p{N}]+";
        String[] contentWords = content.split(nonLetterOrDigitRegex);

        for (String contentWord : contentWords) {
            if(!(webPageKeywordIndex.containsKey(contentWord))){
                List<WebPage> webPagesToWord = new ArrayList<>();
                webPagesToWord.add(webPage);
                webPageKeywordIndex.put(contentWord,webPagesToWord);
            }else {
                List<WebPage> webPages = webPageKeywordIndex.get(contentWord);
                if(!(webPages.contains(webPage))){
                    webPages.add(webPage);
                }

            }
        }
    }
}
