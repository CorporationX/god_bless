package faang.school.godbless.google_search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Browser {
    Map<String, List<WebPage>> index = new HashMap<>();

    public void addToIndex(WebPage webPage){
        List<String> keyWords = processContent(webPage.getContent());
        for(String keyWord : keyWords){
            index.computeIfAbsent(keyWord, keyWordAsKey -> new ArrayList<>());
            index.get(keyWord).add(webPage);
        }
    }

    public List<WebPage> searchWebPages(String keyWord){
        keyWord = keyWord.toLowerCase();
        if(index.containsKey(keyWord)){
            return index.get(keyWord.toLowerCase());
        } else {
            log.warn("Could not find any page with this key work {}", keyWord);
            return new ArrayList<>();
        }
    }

    public void deleteWebPageByUrl(String url){
        for(Map.Entry<String, List<WebPage>> webPageEntry : index.entrySet()){
            List<WebPage> webPageList = webPageEntry.getValue();
            webPageList.removeIf(webPage -> webPage.getUrl().equals(url));
            if(webPageList.isEmpty()){
                index.remove(webPageEntry.getKey());
            }
        }
    }

    public List<String> processContent(String content){
        String onlyWords = content.toLowerCase().replaceAll("[^a-z 0-9]", "");
        return Arrays.stream(onlyWords.split(" ")).filter(string -> !string.isBlank()).toList();
    }

    public void showWebPages(){
        for(Map.Entry<String, List<WebPage>> webPageEntry : index.entrySet()){
            System.out.println("keyWord - " + webPageEntry.getKey());
            for(WebPage webPage : webPageEntry.getValue()){
                System.out.println(webPage);
            }
        }
    }
}
