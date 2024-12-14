package faang.school.godbless.googleSearch;

import java.util.Objects;

public class WebPagesLinkedList implements Cloneable {
    Node head;
    private final Node TAIL = new Node(new WebPage("Последний узел", null, null));

    public WebPagesLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String printLinkedList() {
        if (isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!Objects.equals(head.value.getUrl(), TAIL.value.getUrl())) {
            stringBuilder.append(head.value).append(System.lineSeparator());
            head = head.next;
        }
        return stringBuilder.toString();
    }

    void addNode(Node node) {
        if (head == null) {
            head = node;
            head.next = TAIL;
            TAIL.prev = head;
        } else {
            Node previousNode = TAIL.prev;
            node.next = TAIL;
            node.prev = previousNode;
            previousNode.next = node;
            TAIL.prev = node;
        }
    }

    static void remove(Node nodeToRemove) {
        nodeToRemove.value = nodeToRemove.next.value;
        nodeToRemove.next = nodeToRemove.next.next;
    }

    @Override
    public WebPagesLinkedList clone() {
        try {
            return (WebPagesLinkedList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
