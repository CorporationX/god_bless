package faang.school.godbless.BJS2_8429;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  static Map<String, List<WebPage>> pages = new HashMap<>();

  public static void main(String[] args) {
    addWebPageToCash(new WebPage("url1", "title1", "word1, word4, word10"));
    addWebPageToCash(new WebPage("url2", "title2", "word3, word4, word9"));
    addWebPageToCash(new WebPage("url3", "title3", "word8, word4, word10"));
    System.out.println(pages);
    System.out.println(getAllPagesByWord("word4"));
    deleteWebPageByUrl("url1");
    System.out.println(pages);
  }

  public static void addWebPageToCash(WebPage webPage) {
    String[] words = webPage.getContent().split(" ");
    for (String word : words) {
      word = word.replaceAll("[^\\da-zA-z]", "");
      pages.computeIfAbsent(word, s -> new ArrayList<>()).add(webPage);
    }
  }

  public static List<WebPage> getAllPagesByWord(String word) {
    return pages.get(word);
  }

  public static void deleteWebPageByUrl(String url) {
    for (Map.Entry<String, List<WebPage>> entry : pages.entrySet()) {
      entry.setValue(entry.getValue().stream().filter(page -> !page.getUrl().equals(url)).toList());
    }
  }
}
