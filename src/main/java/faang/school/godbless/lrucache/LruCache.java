package faang.school.godbless.lrucache;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LruCache {
    private final int cacheSize;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, Data> allData = new HashMap<>();
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
        this.cacheSize = capacity;
    }

    public void put(Data data) {
        allData.put(data.getId(), data);
        if (cache.containsKey(data.getId())) {
            Node node = cache.get(data.getId());
            moveToTail(node);
        } else {
            Node node = new Node(data);
            if (cache.size() < cacheSize) {
                addToTail(node);
            } else {
                cache.remove(head.data.getId());
                removeHead();
                addToTail(node);
            }
            cache.put(data.getId(), node);
        }
    }

    public Data getData(int id) {
        if (cache.containsKey(id)) {
            Node node = cache.get(id);
            node.data.setTimestamp(LocalDateTime.now());
            moveToTail(node);
            return node.data;
        } else {
            if (allData.containsKey(id)) {
                Node node = new Node(allData.get(id));
                node.data.setTimestamp(LocalDateTime.now());
                put(node.data);
                return node.data;
            }
        }
        return null;
    }

    private void moveToTail(Node node) {
        if (node != tail) {
            if (node != head) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                addToTail(node);
            } else {
                removeHead();
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }

    private void addToTail(Node node) {
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    private void removeHead() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node prevHead = head;
            head = head.next;
            head.prev = null;
            prevHead.next = null;
        }
    }

    public void printCache() {
        for (Map.Entry<Integer, Node> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().data);
        }
    }

    private static class Node {
        Data data;
        Node next;
        Node prev;

        public Node(Data data) {
            this.data = data;
        }
    }
}
