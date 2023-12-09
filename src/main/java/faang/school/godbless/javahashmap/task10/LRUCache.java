package faang.school.godbless.javahashmap.task10;

import java.util.HashMap;

@lombok.Data
public class LRUCache {

    public int CACHE_SIZE = 4;
    public HashMap<Integer, Node> cache;
    public Node head;
    public Node tail;

    public LRUCache() {
        this.cache = new HashMap<>();
        this.head = new Node(-1, null);
        this.tail = new Node(-1, null);
        head.nodeRight = tail;
        head.nodeLeft = tail;
        tail.nodeRight = head;
        tail.nodeLeft = head;
    }

    public Data get(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node node = cache.get(key);
        moveToHead(node);

        return node.getData();
    }

    public void add(Data data) {
        int key = data.getId();
        if (cache.containsKey(key)) {
            cache.get(key).setData(data);
            moveToHead(cache.get(key));
        } else {
            Node node = new Node(data);
            if (cache.size() >= this.CACHE_SIZE) {
                Node rm = tail.getNodeLeft();
                remove(rm);
                cache.remove(rm.getKey());
            }
            insertHead(node);
            cache.put(key, node);
        }
    }


    public void moveToHead(Node node) {
        remove(node);
        insertHead(node);
    }


    public void insertHead(Node node) {
        Node next = head.nodeRight;
        head.nodeRight = node;
        node.nodeLeft = head;
        node.nodeRight = next;
        next.nodeLeft = node;
    }

    public void remove(Node node) {
        Node front = node.nodeLeft;
        Node end = node.nodeRight;
        front.nodeRight = end;
        end.nodeLeft = front;
    }
}
