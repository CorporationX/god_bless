package faang.school.godbless.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

public class LRUCache<K, V> {

    private final Map<K, Node<K, V>> cache = new HashMap();
    private final static int CACHE_SIZE = 4;
    private Node head;
    private Node tail;

    public void put(K key, V value) {
        Node<K, V> node = new Node(key, value);
        if (cache.size() < CACHE_SIZE) {
            addToTail(node);
        } else {
            cache.remove(head.key);
            removeHead();
            addToTail(node);
        }
        cache.put(key, node);
    }

    public Optional<V> get(K key) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            moveToTail(node);
            return Optional.of(node.value);
        }
        return Optional.empty();
    }

    public void forEach(BiConsumer<K, V> consumer) {
        for (Map.Entry<K, Node<K, V>> entry : cache.entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue().getValue());
        }
    }

    public int size() {
        return cache.size();
    }

    private void moveToTail(Node node) {
        if (node != tail) {
            if (node != head) {
                node.left.right = node.right;
                node.right.left = node.left;
                tail.right = node;
                node.left = tail;
                tail = node;
                tail.right = null;
            } else {
                Node prevHead = removeHead();
                tail.right = prevHead;
                prevHead.left = tail;
                prevHead.right = null;
                tail = prevHead;
            }
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

    private Node removeHead() {
        if (head == tail) {
            Node tmp = head;
            head = null;
            tail = null;
            return tmp;
        } else {
            Node prevHead = head;
            head.right.left = null;
            head = head.right;
            prevHead.right = null;
            return prevHead;
        }
    }

    private class Node<K, V> {
        private final K key;
        private final V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
