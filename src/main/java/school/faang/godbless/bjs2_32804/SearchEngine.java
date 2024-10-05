package school.faang.godbless.bjs2_32804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

public class SearchEngine {

  private Map<String, List<WebPage>> index = new HashMap<>();

  public void addToIndex(WebPage page) {
    StringTokenizer tokenizer = new StringTokenizer(page.getContent());
    while (tokenizer.hasMoreTokens()) {
      String word = tokenizer.nextToken();
      index.computeIfAbsent(word, key -> new ArrayList<>()).add(page);
    }
  }

  public Optional<List<WebPage>> findPages(String word) {
    return index.containsKey(word) ? Optional.of(index.get(word)) : Optional.empty();
  }

  public void removeByUrl(String url) {
    index.forEach((key, value) -> value.removeIf(page -> page.getUrl().equals(url)));
  }
}
