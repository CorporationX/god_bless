package faang.school.godbless.task_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchingEngine {
    private final Map<String, Node> INDEX = new HashMap<>();
    private final Set<WebPage> PAGES = new HashSet<>();
    private final Map<String, List<Node>>  URL_INDEX = new HashMap<>();

    public boolean indexPage(WebPage page) {
        if (page == null || PAGES.contains(page)) {
            return false;
        }

        PAGES.add(page);

        String[] words = page.getContent().split("[^A-Za-zА-Яа-я]+");
        for (String word : words) {
            Node node = new Node(page, word, null, null);

            if (INDEX.containsKey(word)) {
                Node tail = INDEX.get(word);
                tail.next = node;
                node.prev = tail;
            }
            INDEX.put(word, node);

            if (!URL_INDEX.containsKey(page.getUrl())) {
                URL_INDEX.put(page.getUrl(), new ArrayList<>());
            }
            URL_INDEX.get(page.getUrl()).add(node);
        }

        return true;
    }

    public List<WebPage> findByKeyword(String keyword) {
        if (keyword == null || !INDEX.containsKey(keyword)) {
            return null;
        }

        List<WebPage> pages = new ArrayList<>();
        Node dummy = INDEX.get(keyword);
        while (dummy != null) {
            pages.add(dummy.page);
            dummy = dummy.prev;
        }

        return pages;
    }

    public boolean removePageByUrl(String url) {
        if (url == null || !URL_INDEX.containsKey(url)) {
            return false;
        }
        List<Node> pages = URL_INDEX.get(url);

        URL_INDEX.remove(url);
        PAGES.remove(pages.get(0).page);

        for (Node node : pages) {
            if (node.prev == null && node.next == null) {
                INDEX.remove(node.word);
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
