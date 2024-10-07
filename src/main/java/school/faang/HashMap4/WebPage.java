package school.faang.HashMap4;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class WebPage {
    private String url;
    private String title;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

    public WebPage(String url) {
        this.url = url;
    }

    public static void index(WebPage webPage, Map<String, List<WebPage>> webPageMap){
        String[] words = webPage.getContent().toLowerCase().split(" ");
        for (String word : words){
            webPageMap.computeIfAbsent(word, k -> new ArrayList<>()).add(webPage);
        }
    }

    public static List<WebPage> searchKeyWord(String keyWord, Map<String, List<WebPage>> webPageMap){
        if (webPageMap.get(keyWord.toLowerCase()) != null){
            return webPageMap.get(keyWord.toLowerCase());
            } else {
            return null;
        }
    }

    public static void deletePage (String url, Map<String, List<WebPage>> webPageMap){
        WebPage page = new WebPage(url);
        for (var entry : webPageMap.entrySet()){
            if(entry.getValue().contains(page)){
                entry.getValue().remove(page);
            }
        }
    }

    public static void printMap(Map<String, List<WebPage>> webPageMap){
        for (var entry: webPageMap.entrySet()){
            System.out.println("Word: " + entry.getKey() + "\nPages: ");
            printWebPageList(entry.getValue());
        }
    }

    public static void printWebPageList(List<WebPage> webPageList) {
        if (webPageList != null) {
            for (WebPage page : webPageList) {
                System.out.println(page.getTitle());
            }
        } else {
            System.out.println("not found");
        }
        System.out.println();
    }
}
