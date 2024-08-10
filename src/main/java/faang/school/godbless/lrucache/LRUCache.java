package faang.school.godbless.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public void get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            node.value.updateTimestamp();
        }
    }

    public void put(int key, Data value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(head.key);
                removeHead();
            }
            addToTail(node);
            map.put(key, node);
        }
    }

    private void addToTail(Node node) {
        if (tail != null) {
            tail.right = node;
            node.left = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    private void moveToTail(Node node) {
        if (node == tail) return;
        if (node == head) {
            head = head.right;
            if (head != null) {
                head.left = null;
            }
        } else {
            node.left.right = node.right;
            if (node.right != null) {
                node.right.left = node.left;
            }
        }
        node.left = tail;
        node.right = null;
        tail.right = node;
        tail = node;
    }

    private void removeHead() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.right;
            head.left = null;
        }
    }

    public void printCache() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.value.getId() +
                    ", Value: " + current.value.getValue() +
                    ", Timestamp: " + current.value.getTimestamp());
            current = current.right;
        }
    }

    private static class Node {
        int key;
        Data value;
        Node left;
        Node right;

        public Node(int key, Data value) {
            this.key = key;
            this.value = value;
        }
    }
}