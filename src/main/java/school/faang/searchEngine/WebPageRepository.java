package school.faang.searchEngine;

import lombok.Getter;
import school.faang.searchEngine.nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;

@Getter
public class WebPageRepository {

  private final Map<String, List<WebPage>> webPages = new HashMap<>();
  private final Map<String, List<Node>> nodesByWords = new HashMap<>();
  private final HashSet<WebPage> noRepetitionsWebPages = new HashSet<>();

  public void indexingPage(WebPage page) {
    String[] words = page.getContent().split(" ");

    for(String word : words) {
      if(!noRepetitionsWebPages.contains(page)) {
        webPages.computeIfAbsent(word, k -> new ArrayList<>()).add(page);
      }
    }
    noRepetitionsWebPages.add(page);
  }

  public List<WebPage> searchPages(String keyWord) {
    return webPages.get(keyWord);
  }

  public void removePage(String url) {
    for(Map.Entry<String, List<WebPage>> entry : webPages.entrySet()) {
      entry.getValue().removeIf(page -> page.getUrl().equals(url));
    }
  }
}
