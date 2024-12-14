package faang.school.godbless.googleSearch;

public class Node {
    WebPage value;
    Node prev;
    Node next;

    public Node(WebPage value) {
        this.value = value;
        prev = null;
        next = null;
    }
}
