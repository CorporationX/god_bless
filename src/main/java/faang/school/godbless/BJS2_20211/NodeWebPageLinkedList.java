package faang.school.godbless.BJS2_20211;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NodeWebPageLinkedList {

    private NodeWebPage head;
    private NodeWebPage tail;
    private int size;

    @Setter
    @Getter
    public static class NodeWebPage {
        private WebPage webPage;
        private NodeWebPage leftNode;
        private NodeWebPage rightNode;
        private NodeWebPageLinkedList myList;

        public NodeWebPage(WebPage webPage) {
            this.webPage = webPage;
        }
    }

    public void add(NodeWebPage nodeWebPage) {
        nodeWebPage.myList = this;
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
            System.out.println(current.getWebPage().getUrl());
            current = current.getRightNode();
        }
        System.out.println();

    }

    public List<WebPage> getListPages() {
        List<WebPage> result = new ArrayList<>();
        NodeWebPage current = head;
        while (current != null) {
            result.add(current.getWebPage());
            current = current.getRightNode();
        }
        return result;
    }
}
