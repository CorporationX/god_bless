package faang.school.godbless.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cacheMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
    }

    public Data get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            moveToTail(node);
            node.getValue().updateTimestamp();
            return node.getValue();
        }
        return null;
    }

    public void put(int key, Data value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.setValue(value);
            moveToTail(node);
        } else {
            Node node = new Node(key, value);
            if (cacheMap.size() == capacity) {
                cacheMap.remove(head.getKey());
                removeHead();
            }
            addToTail(node);
            cacheMap.put(key, node);
        }
    }

    private void addToTail(Node node) {
        if (tail != null) {
            tail.setRight(node);
            node.setLeft(tail);
        } else {
            head = node;
        }
        tail = node;
    }

    private void moveToTail(Node node) {
        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.getRight();
            if (head != null) {
                head.setLeft(null);
            }
        } else {
            node.getLeft().setRight(node.getRight());
            if (node.getRight() != null) {
                node.getRight().setLeft(node.getLeft());
            }
        }
        node.setLeft(tail);
        node.setRight(null);
        tail.setRight(node);
        tail = node;
    }

    private void removeHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getRight();
            head.setLeft(null);
        }
    }

    public void printCache() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.getValue().getId() +
                    ", Value: " + current.getValue().getValue() +
                    ", Timestamp: " + current.getValue().getTimestamp());
            current = current.getRight();
        }
    }
}