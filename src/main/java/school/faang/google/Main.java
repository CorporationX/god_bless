package school.faang.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final Map<String, List<WebPage>> INDEX = new HashMap<>();
  private static final Map<String, WebPage> URLS = new HashMap<>();

  public static void main(String[] args) {
    WebPage page1 = new WebPage("url1", "title1", "content- and-news");
    WebPage page2 = new WebPage("url2", "title2", "content%and");
    WebPage page3 = new WebPage("url3", "title3", "content");
    addPage(page1);
    addPage(page2);
    addPage(page3);
    String keyword = "content";
    System.out.println(findPages(keyword));
    removePage("url2");
    System.out.println(findPages(keyword));
  }

  private static void addPage(WebPage page) {
    URLS.put(page.getUrl(), page);
    String[] words = page.getContent().split("\\W+");
    for (String word : words) {
      List<WebPage> pages = INDEX.computeIfAbsent(word, k -> new ArrayList<>());
      pages.add(page);
    }
  }

  private static List<WebPage> findPages(String word) {
    return INDEX.get(word);
  }

  private static void removePage(String url) {
    WebPage page = URLS.get(url);
    for (Map.Entry<String, List<WebPage>> entry : INDEX.entrySet()) {
      List<WebPage> pages = entry.getValue();
      pages.remove(page);
    }
  }

}
