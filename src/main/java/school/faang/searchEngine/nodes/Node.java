package school.faang.searchEngine.nodes;

import lombok.Data;
import school.faang.searchEngine.WebPage;

public class Node {
  public WebPage webPage;
  public Node prev;
  public Node next;

  public Node(WebPage webPage) {
    this.webPage = webPage;
  }
}
