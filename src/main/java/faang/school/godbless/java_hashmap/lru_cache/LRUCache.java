package faang.school.godbless.java_hashmap.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }

        @Override
        public String toString() {
            return "{" + value + '}';
        }
    }

    private int CACHE_SIZE;
    private Node<K, V> head, tail;
    private Map<K, Node<K, V>> map;

    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }


    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (map.size() == CACHE_SIZE && node == null) {
            Node<K, V> lastNode = tail.prev;
            delete(lastNode);
            map.remove(lastNode.key);
            createNode(key, value);
        } else {
            if (node == null) {
                createNode(key, value);
            } else {
                node.value = value;
                update(node);
            }
        }

    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        update(node);
        return node.value;
    }

    private void createNode(K key, V value) {
        Node<K, V> node = new Node(key, value);
        map.put(key, node);
        add(node);
    }

    private void add(Node<K, V> node) {
        Node<K, V> after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void delete(Node<K, V> node) {
        Node<K, V> after = node.next;
        Node<K, V> before = node.prev;
        before.next = after;
        after.prev = before;
    }

    private void update(Node<K, V> node) {
        delete(node);
        add(node);
    }


    public void printCacheState() {
        map.entrySet().stream().forEach(entry -> System.out.println("ID: " + entry.getKey() + ", Data: " + entry.getValue()));
    }
}