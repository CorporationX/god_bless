package faang.school.godbless.cacheLRU;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, Data> dataMap = new HashMap<>();
    private static Map<Integer, Node> LRUCache = new HashMap<>();
    private static final int CACHE_SIZE = 3;
    static Node head;
    static Node tail;

    public static void addData(Data data) {
        Node node = new Node(data);
        updateTimestamp(node.data);
        if (LRUCache.size() < CACHE_SIZE) {
            addToTail(node);
        } else {
            LRUCache.remove(head.data.getId());
            removeHead();
            addToTail(node);
        }
        LRUCache.put(data.getId(), node);
    }

    public static Data getData(int id) {
        Data result;
        if (LRUCache.containsKey(id)) {
            Node node = LRUCache.get(id);
            moveToTail(node);
            result = node.data;
            updateTimestamp(node.data);
        } else {
            Node node = new Node(dataMap.get(id));
            updateTimestamp(node.data);
            addData(node.data);
            result = node.data;
        }
        return result;
    }

    private static void updateTimestamp(Data data) {
        data.setTimestamp(LocalDateTime.now());
    }

    private static void moveToTail(Node node) {
        if (node != tail) {
            if (node == head) {
                Node removedHead = removeHead();
                tail.right = removedHead;
                removedHead.left = tail;
                removedHead.right = null;
                tail = removedHead;
            } else {
                node.left.right = node.right;
                node.right.left = node.left;
                addToTail(node);
            }
        }
    }

    private static void addToTail(Node node) {
        if (tail != null) {
            tail.right = node;
            node.left = tail;
            node.right = null;
        } else {
            head = node;
        }
        tail = node;
    }

    private static Node removeHead() {
        Node prevHead = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.right;
            head.left = null;
            prevHead.right = null;
        }
        return prevHead;
    }

    public static void printCache() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Node> entry : LRUCache.entrySet()) {
            stringBuilder.append(entry.getValue().data).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        dataMap.put(1, new Data(1, "Значение", LocalDateTime.of(2024, 9, 18, 23, 54)));
        dataMap.put(2, new Data(2, "Значение", LocalDateTime.of(2024, 7, 18, 23, 54)));
        dataMap.put(3, new Data(3, "Значение", LocalDateTime.of(2024, 7, 19, 23, 54)));
        dataMap.put(4, new Data(4, "Значение", LocalDateTime.of(2024, 7, 20, 23, 54)));
        dataMap.put(5, new Data(5, "Значение", LocalDateTime.of(2024, 7, 13, 23, 54)));
        dataMap.put(6, new Data(6, "Значение", LocalDateTime.of(2024, 7, 14, 23, 54)));
        dataMap.put(7, new Data(7, "Значение", LocalDateTime.of(2024, 7, 15, 23, 54)));
        dataMap.put(8, new Data(8, "Значение", LocalDateTime.of(2024, 7, 17, 3, 54)));
        dataMap.put(9, new Data(9, "Значение", LocalDateTime.of(2024, 7, 17, 2, 54)));
        dataMap.put(10, new Data(10, "Значение", LocalDateTime.of(2024, 7, 17, 19, 54)));
        dataMap.put(11, new Data(11, "Значение", LocalDateTime.of(2024, 7, 17, 10, 54)));
        getData(2);
        getData(7);
        printCache();
        addData(dataMap.get(3));
        addData(dataMap.get(4));
        printCache();
        addData(dataMap.get(1));
        printCache();
        System.out.println(getData(2));
        System.out.println("-------------------");
        addData(dataMap.get(5));
        getData(6);
        printCache();
    }
}
