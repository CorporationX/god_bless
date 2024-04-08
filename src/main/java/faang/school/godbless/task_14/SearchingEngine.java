package faang.school.godbless.task_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchingEngine {
    private final Map<String, Node> keyword_index = new HashMap<>();
    private final Set<WebPage> allPages = new HashSet<>();
    private final Map<String, List<Node>> url_index = new HashMap<>();

    public boolean indexPage(WebPage page) {
        if (page == null || allPages.contains(page)) {
            return false;
        }

        allPages.add(page);

        String[] words = page.getContent().split("[^A-Za-zА-Яа-я]+");
        for (String word : words) {
            Node node = new Node(page, word, null, null);

            if (keyword_index.containsKey(word)) {
                Node tail = keyword_index.get(word);
                tail.next = node;
                node.prev = tail;
            }
            keyword_index.put(word, node);

            if (!url_index.containsKey(page.getUrl())) {
                url_index.put(page.getUrl(), new ArrayList<>());
            }
            url_index.get(page.getUrl()).add(node);
        }

        return true;
    }

    public List<WebPage> findByKeyword(String keyword) {
        if (keyword == null || !keyword_index.containsKey(keyword)) {
            return null;
        }

        List<WebPage> pages = new ArrayList<>();
        Node dummy = keyword_index.get(keyword);
        while (dummy != null) {
            pages.add(dummy.page);
            dummy = dummy.prev;
        }

        return pages;
    }

    public boolean removePageByUrl(String url) {
        if (url == null || !url_index.containsKey(url)) {
            return false;
        }
        List<Node> pages = url_index.get(url);

        url_index.remove(url);
        allPages.remove(pages.get(0).page);

        for (Node node : pages) {
            if (node.prev == null && node.next == null) {
                keyword_index.remove(node.word);
            } else if (node.prev == null) {
                node.next.prev = null;
            } else if (node.next == null) {
                node.prev.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        return true;
    }

    private static class Node {
        WebPage page;
        String word;
        Node prev;
        Node next;

        public Node(WebPage page, String word, Node prev, Node next) {
            this.page = page;
            this.word = word;
            this.prev = prev;
            this.next = next;
        }
    }
}
