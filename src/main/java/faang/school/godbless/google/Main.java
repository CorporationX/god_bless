package faang.school.godbless.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, List<WebPage>> webPages = new HashMap<>();

    public static void main(String[] args) {
        webPages.put("Java",new ArrayList<>());
        WebPage java = new WebPage("java.com","Java","Get Java for desktop applications");
        addNewWebPage(java);
        System.out.println(findByKeyWord("Java"));

    }


    public static void addNewWebPage(WebPage webPage){
        Set<String> sortedContent = new HashSet<>();
        for(String word :webPage.getContent().trim().split("\\s+|,\\s*|\\.\\s*")){
            sortedContent.add(word);
        }
        for(String sortedWord : sortedContent){
            for (String key : webPages.keySet()){
                if(key.equals(sortedWord)){
                    webPages.get(key).add(webPage);
                }
            }
        }
    }
    public static List<WebPage> findByKeyWord(String keyWord){
        return webPages.get(keyWord);
    }

    public static void deleteByUrl(String url){
        for(String key : webPages.keySet()){
            List<WebPage> webs =new ArrayList<>(webPages.get(key));
        }
    }
}
