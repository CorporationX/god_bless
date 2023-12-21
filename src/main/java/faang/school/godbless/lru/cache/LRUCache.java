package faang.school.godbless.lru.cache;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    @Getter Node head = null;
    Node tail = null;
    private final int CACHE_SIZE;

    public LRUCache (int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    public Data get (int key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node node = cache.get(key);
        removeNode(node);
        addNode(node);

        return node.data;
    }

    public void put (Data data) {
        int key = data.getId();

        Node node = new Node();

        if (cache.containsKey(key)) {
            Node nodeToUpdate = cache.get(key);
            nodeToUpdate.data = data;
            return;
        }

        if (cache.size() == CACHE_SIZE) {
            Node nodeToDelete = tail;
            cache.remove(nodeToDelete.key);
            removeNode(nodeToDelete);
        }

        node.key = key;
        node.data = data;
        addNode(node);
        cache.put(key, node);
    }

    public void removeNode (Node node) {
        if (node.equals(tail)) {
            if (node.prev != null) {
                tail = node.prev;
                tail.next = null;
            } else {
                node = null;
            }
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public void addNode (Node node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}
