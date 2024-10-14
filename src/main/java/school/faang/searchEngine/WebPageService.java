package school.faang.searchEngine;

import java.util.*;

public class WebPageService {
  private final Map<String, List<WebPage>> webPages = new HashMap<>();
  private final Set<WebPage> noRepetitionsWebPages = new HashSet<>();

  private String[] splitByWords(String content) {
    if(content == null) return new String[0];

    return content.replaceAll("[^а-яА-ЯёЁa-zA-Z0-9 ]", "").trim().split("\\s+");
  }

  public void indexingPage(WebPage page) {
    String[] words = splitByWords(page.getContent());

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
