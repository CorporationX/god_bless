package faang.school.godbless.lrucache;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {
    private static final int CACHE_SIZE = 3;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, Data> allData = new HashMap<>();
    private final Node head;
    private final Node tail;

    public LruCache() {
        head = new Node(new Data(0, 0));
        tail = new Node(new Data(0, 0));
        head.next = tail;
        tail.prev = head;
    }

    public int get(int id) {
        if (cache.containsKey(id)) {
            Node node = cache.get(id);
            moveToTail(node);
            return  -1;
        }
        return -1;
    }

    public void moveToTail(Node node) {

    }

    public static class Node {
        Data data;
        Node next;
        Node prev;

        public Node(Data data) {
            this.data = data;
        }
    }
}
