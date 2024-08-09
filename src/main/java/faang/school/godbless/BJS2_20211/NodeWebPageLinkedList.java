package faang.school.godbless.BJS2_20211;

import lombok.Getter;
import lombok.Setter;

public class NodeWebPageLinkedList {
    private NodeWebPage head;
    private NodeWebPage tail;
    private int size;

    public int size() {
        return size;
    }

    @Setter
    @Getter
    public static class NodeWebPage {
        private WebPage webPage;
        private NodeWebPage leftNode;
        private NodeWebPage rightNode;

        public NodeWebPage(WebPage webPage) {
            this.webPage = webPage;
        }
    }


    public void add(NodeWebPage nodeWebPage) {
        if (tail == null) {
            head = tail = nodeWebPage;
        } else {
            nodeWebPage.leftNode = tail;
            tail.rightNode = nodeWebPage;
            tail = nodeWebPage;
        }
        size++;
    }

    public void printList() {
        NodeWebPage current = head;
        while (current != null) {
//            if (current.getWebPage().getContent().contains(word)) {
                System.out.println(current.getWebPage().getTitle());
//            }
            current = current.getRightNode();
        }
        System.out.println();
    }

    public static class Test {
    }
}
