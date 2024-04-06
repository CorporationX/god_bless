package faang.school.godbless.lrucache;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LruCache {
    private final int CACHE_SIZE;
    private final Map<Integer, Node> CACHE = new HashMap<>();
    private final Map<Integer, Data> ALL_DATA = new HashMap<>();
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
        this.CACHE_SIZE = capacity;
    }

    public void put(Data data) {
        ALL_DATA.put(data.getId(), data);
        if (CACHE.containsKey(data.getId())) {
            Node node = CACHE.get(data.getId());
            node.data.setTimestamp(LocalDateTime.now());
            moveToTail(node);
        } else {
            Node node = new Node(data);
            if (CACHE.size() < CACHE_SIZE) {
                addToTail(node);
            } else {
                CACHE.remove(head.data.getId());
                removeHead();
                addToTail(node);
            }
            CACHE.put(data.getId(), node);
        }
    }

    public Data getData(int id) {
        if (CACHE.containsKey(id)) {
            Node node = CACHE.get(id);
            node.data.setTimestamp(LocalDateTime.now());
            moveToTail(node);
            return node.data;
        } else {
            if (ALL_DATA.containsKey(id)) {
                Node node = new Node(ALL_DATA.get(id));
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
        for (Map.Entry<Integer, Node> entry : CACHE.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().data);
        }
    }

    public static class Node {
        Data data;
        Node next;
        Node prev;

        public Node(Data data) {
            this.data = data;
        }
    }
}
