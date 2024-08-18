package faang.school.godbless.Maps.BJS2_20420;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, Node> cacheMap = new HashMap<>();
    private static final int CACHE_SIZE = 5;
    private static Node head;
    private static Node tail;

    public static void main(String[] args) {
        Data dataFirst = new Data("First");
        Data dataSecond = new Data("Second");
        Data dataThird = new Data("Third");
        Data dataFourth = new Data("Fourth");
        Data dataFifth = new Data("Fifth");
        put(1, dataFirst);
        put(2, dataSecond);
        put(3, dataThird);
        Data dataSixth = getData(2);
        put(3, dataSixth);
        put(4, dataFourth);
        Data dataSeventh = getData(1);
        put(5, dataFifth);
        put(8, dataSeventh);

        print();
    }

    public static Data getData(int key) {
        Node node = cacheMap.get(key);
        Data data = node.data;
        if (cacheMap.containsKey(key)) {
            moveToTail(node);
            data.updateTimestamp();
            return data;
        }
        return null;
    }

    public static void put(int key, Data data) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.data = data;
            moveToTail(node);
        } else {
            Node node = new Node(key, data);
            if (cacheMap.size() < CACHE_SIZE) {
                addToTail(node);
            } else {
                cacheMap.remove(head.key);
                removeHead();
                addToTail(node);
            }
            data.updateTimestamp();
            cacheMap.put(key, node);
        }

    }

    private static void removeHead() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.right.left = null;
            head = head.right;
        }
    }

    private static void addToTail(Node node) {
        if (tail != null) {
            tail.right = node;
            node.left = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    public static void moveToTail(Node node) {
        if (tail != node) {
            if (node != head) {
                node.left.right = node.right;
                node.right.left = node.left;
                tail.right = node;
                node.left = tail;
                tail = node;
                node.right = null;
            } else {
                removeHead();
                tail.right = node;
                node.left = tail;
                tail = node;
                node.right = null;
            }
        }
    }


    private static class Node {
        int key;
        Data data;
        Node left;
        Node right;

        public Node(int key, Data data) {
            this.key = key;
            this.data = data;
        }
    }

    private static void print() {
        for (Map.Entry<Integer, Node> entry : cacheMap.entrySet()) {
            System.out.println(entry.getKey() + "-----" + entry.getValue().data);
        }
    }
}
