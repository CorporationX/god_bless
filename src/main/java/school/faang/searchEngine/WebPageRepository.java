package school.faang.searchEngine;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Getter
public class WebPageRepository {

  private final Map<String, LinkedList<WebPage>> webPages = new HashMap<>();

  public void indexingPage(WebPage page) {
    String[] words = page.getContent().split(" ");

    for(String word : words) {
      webPages.computeIfAbsent(word, k -> new LinkedList<>()).add(page);
    }
  }

  public LinkedList<WebPage> searchPages(String keyWord) {
    return webPages.get(keyWord);
  }

  public void removePage(String url) {
    for(Map.Entry<String, LinkedList<WebPage>> entry : webPages.entrySet()) {
      entry.getValue().removeIf(page -> page.getUrl().equals(url));
    }
  }
}
