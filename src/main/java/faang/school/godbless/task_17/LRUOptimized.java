package faang.school.godbless.task_17;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUOptimized {
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, Data> allData = new HashMap<>();
    private final Node head;
    private final Node tail;
    private static final int CACHE_SIZE = 3;

    public LRUOptimized() {
        head = new Node(new Data(0, 0));
        tail = new Node(new Data(0, 0));
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node popLast() {
        Node res = tail.prev;
        remove(res);
        return res;
    }

    private void moveToFirst(Node node) {
        remove(node);
        addFirst(node);
    }

    public void put(Data data) {
        allData.put(data.getId(), data);
        Node node = cache.get(data.getId());
        if (node == null) {
            Node newNode = new Node(data);
            cache.put(data.getId(), newNode);
            addFirst(newNode);
            if (cache.size() > CACHE_SIZE) {
                Node tail = popLast();
                cache.remove(tail.data.getId());
            }
        } else {
            node.data = data;
            node.data.setTimestamp(LocalDateTime.now());
            moveToFirst(node);
        }
    }

    public Data get(int id) {
        Node node = cache.get(id);

        if (node == null) {
            Data data = allData.get(id);
            data.setTimestamp(LocalDateTime.now());
            put(data);
            return data;
        }

        node.data.setTimestamp(LocalDateTime.now());
        moveToFirst(node);
        return node.data;
    }

    public List<Data> getCache() {
        return cache.values().stream().map(o -> o.data).sorted(Comparator.comparing(Data::getTimestamp)).toList();
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
