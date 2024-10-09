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
            String contentWordLowerCase = contentWord.toLowerCase();

            if(!(webPageKeywordIndex.containsKey(contentWordLowerCase))){
                List<WebPage> webPagesToWord = new ArrayList<>();
                webPagesToWord.add(webPage);
                webPageKeywordIndex.put(contentWordLowerCase,webPagesToWord);
            }else {
                List<WebPage> webPages = webPageKeywordIndex.get(contentWordLowerCase);
                if(!(webPages.contains(webPage))){
                    webPages.add(webPage);
                }

            }
        }
    }

    public List<WebPage> getWebPagesByWord(String keyWord,Map<String, List<WebPage>> webPageKeywordIndex){
        String contentWordLowerCase = keyWord.toLowerCase();
        return  webPageKeywordIndex.get(contentWordLowerCase);
    }
}
