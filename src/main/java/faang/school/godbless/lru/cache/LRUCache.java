package faang.school.godbless.lru.cache;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    @Getter
    Node head = null;
    Node tail = null;
    private static final int CACHE_SIZE = 5;

    public Data get(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node node = cache.get(key);

        moveNodeToHead(node);
        return node.getData();
    }

    public void put(Data data) {
        int key = data.getId();

        if (cache.containsKey(key)) {
            Node nodeToUpdate = cache.get(key);

            nodeToUpdate.setData(data);
            moveNodeToHead(nodeToUpdate);
            return;
        }

        if (cache.size() == CACHE_SIZE) {
            Node nodeToDelete = tail;

            cache.remove(tail.getKey());
            removeNode(nodeToDelete);
        }

        Node node = new Node(key, data);

        addNode(node);
        cache.put(key, node);
    }

    private void removeNode(Node node) {
        if (node.equals(head)) {
            head = node.next;
            head.prev = null;
            return;
        }

        if (node.equals(tail)) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node) {
        if (head == null) {
            // set first (head) node and last (tail) node
            head = node;
            tail = head;
            head.next = tail;
            tail.prev = head;

            // set borders to list
            head.prev = null;
            tail.next = null;
        } else {
            // set new item to start of the list
            node.next = head;
            head.prev = node;
            head = node;
        }

        node.getData().updateTimestamp();
    }

    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}
