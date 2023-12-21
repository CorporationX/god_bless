package faang.school.godbless.lru.cache;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    @Getter
    Node head = null;
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

        return node.getData();
    }

    public void put (Data data) {
        int key = data.getId();

        if (cache.containsKey(key)) {
            Node nodeToUpdate = cache.get(key);
            nodeToUpdate.setData(data);
            return;
        }

        if (cache.size() == CACHE_SIZE) {
            Node nodeToDelete = tail;
            cache.remove(nodeToDelete.getKey());
            removeNode(nodeToDelete);
        }

        Node node = new Node(key, data);

        addNode(node);
        cache.put(key, node);
    }

    public void removeNode (Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev.next = node.next;
        tail = node.prev;
        tail.next = null;
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
