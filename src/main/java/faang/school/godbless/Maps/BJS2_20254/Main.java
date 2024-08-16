package faang.school.godbless.Maps.BJS2_20254;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<WebPage>> webPageList = new HashMap<>();
    public static void main(String[] args) {

        WebPage webPage = new WebPage("https://www.amrood.com");
        indexWebPage(webPage);

        remove("https://www.amrood.com");
        System.out.println(search("Good"));
        System.out.println(webPageList);
    }

    public static void indexWebPage(WebPage webPage)  {
        String[] strings = webPage.getContent().split("\\W+");
        for (String str : strings){
            webPageList.computeIfAbsent(str, k -> new ArrayList<WebPage>());
            webPageList.get(str).add(webPage);
        }
    }
    public static List<WebPage> search(String string){
        return webPageList.get(string);
    }
    public static void remove(String url){
        for(Map.Entry<String, List<WebPage>> entry : webPageList.entrySet()){
           for(WebPage webPage : entry.getValue()) {
               if(webPage.getUrl().equals(url)){
                   entry.getValue().remove(webPage);
               }
           }
        }
    }
}
