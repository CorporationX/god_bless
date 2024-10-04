package school.faang.searchEngine.nodes;

import school.faang.searchEngine.WebPage;

public class MyLinkedList {
  private Node first;
  private Node last;

  public void add(WebPage webPage) {
    Node newNode = new Node(webPage);

    if(first == null) {
      first = newNode;
      last = newNode;
      newNode.next = null;
      newNode.prev = null;
    }else {
      last.next = newNode;
      newNode.prev = last;
      last = newNode;
    }
  }

  public void remove(Node node) {
    if(node.next != null) {
      node.next.prev = node.prev;
    }

    if(node.prev != null) {
      node.prev.next = node.next;
    }
  }
}
