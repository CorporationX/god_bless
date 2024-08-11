package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<ValueType> {
    private final int capacity;
    private final Map<String, Node<ValueType>> map = new HashMap<>();
    private Node<ValueType> head;
    private Node<ValueType> tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity size must be greater than 0");
        }
        this.capacity = capacity;
    }

    public ValueType getData(String key) {
        if (key == null || !map.containsKey(key)) {
            return null;
        }

        Node<ValueType> node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void addData(String key, ValueType value) {
        if (key == null || value == null) {
            return;
        }

        if (map.containsKey(key)) {
            Node<ValueType> node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            Node<ValueType> node = new Node<>(key, value);
            if (map.size() >= capacity) {
                map.remove(head.key);
                removeHead();
            }
            addToTail(node);
            map.put(key, node);
        }
    }

    public void print() {
        System.out.println("Current Cache:");
        Node<ValueType> current = head;
        while (current != null) {
            System.out.println("    " + current.value);
            current = current.right;
        }
    }

    private void moveToTail(Node<ValueType> node) {
        if (node == null) {
            return;
        }

        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.right;
            if (head != null) {
                head.left = null;
            }
        } else {
            node.left.right = node.right;
            node.right.left = node.left;
        }
        addToTail(node);
    }

    private void removeHead() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.right;
            head.left = null;
        }
    }

    private void addToTail(Node<ValueType> node) {
        if (node == null) {
            return;
        }

        node.right = null;
        node.left = tail;
        if (tail != null) {
            tail.right = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    private static class Node<ValueType> {
        String key;
        ValueType value;
        Node<ValueType> left;
        Node<ValueType> right;

        public Node(String key, ValueType value) {
            this.key = key;
            this.value = value;
        }
    }
}