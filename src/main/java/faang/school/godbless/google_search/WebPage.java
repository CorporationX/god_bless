package faang.school.godbless.google_search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    public static void addToIndex(Map<String, List<WebPage>> webPageMap, WebPage webPage){
        List<String> keyWords = processContent(webPage.content);
        for(String keyWord : keyWords){
            webPageMap.computeIfAbsent(keyWord, keyWordAsKey -> new ArrayList<>());
            webPageMap.get(keyWord).add(webPage);
        }
    }

    public static List<WebPage> searchWebPages(Map<String, List<WebPage>> webPageMap, String keyWord){
        return webPageMap.get(keyWord.toLowerCase());
    }

    public static void deleteWebPageByUrl(Map<String, List<WebPage>> webPageMap, String url){
        for(Map.Entry<String, List<WebPage>> webPageEntry : webPageMap.entrySet()){
            List<WebPage> webPageList = webPageEntry.getValue();
            webPageList.removeIf(webPage -> webPage.url.equals(url));
        }
    }

    public static List<String> processContent(String content){
        String onlyWords = content.replaceAll("[+\\-*/:^;,.!?@#$%&(){}\\[\\]`~'\"\\\\]", "").toLowerCase();
        return Arrays.stream(onlyWords.split(" ")).filter(string -> !string.isBlank()).toList();
    }
}
