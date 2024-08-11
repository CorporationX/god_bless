package faang.school.godbless.BJS2_20340;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int CACHE_SIZE;
    @Getter
    private final Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.CACHE_SIZE = capacity;
    }

    public Data get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToTail(node);
            return node.data;
        }
        return null;
    }

    public void put(int key, Data data) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.data = data;
            moveToTail(node);
        } else {
            Node node = new Node(key, data);
            if (cache.size() < CACHE_SIZE) {
                addToTail(node);
            } else {
                cache.remove(head.key);
                removeHead();
                addToTail(node);
            }
            cache.put(key, node);
        }
    }

    private Node removeHead() {
        if (head == tail) {
            head = null;
            tail = null;
            return null;
        } else {
            Node prevHead = head;
            head = head.rightNode;
            head.leftNode = null;
            prevHead.rightNode = null;
            return prevHead;
        }
    }

    private void addToTail(Node node) {
        if (tail != null) {
            tail.rightNode = node;
            node.leftNode = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    private void moveToTail(Node node) {
        if (node != tail) {
            if (node != head) {
                node.leftNode.rightNode = node.rightNode;
                node.rightNode.leftNode = node.leftNode;
                tail.rightNode = node;
                node.leftNode = tail;
                tail = node;
            } else {
                Node prevHead = removeHead();
                tail.rightNode = prevHead;
                prevHead.leftNode = tail;
                tail = prevHead;
            }
            tail.rightNode = null;
        }
    }

    public void printLRUCache() {
        for (var entry : cache.entrySet()) {
            Data data = entry.getValue().data;
            System.out.println(data.getId() + " - " + data.getValue() + " - " + data.getTimestamp());
        }
    }

    public static class Node {
        Node leftNode;
        Node rightNode;
        int key;
        Data data;

        public Node(int key, Data data) {
            this.key = key;
            this.data = data;
        }
    }
}
