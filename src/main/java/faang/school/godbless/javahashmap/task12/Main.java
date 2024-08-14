package faang.school.godbless.javahashmap.task12;

import java.time.Instant;
import java.util.*;

public class Main {
    private static final Map<Integer, Data> DATA_MAP = new HashMap<>();
    private static final Map<Integer, Node> CACHE_DATA_MAP = new HashMap<>();
    private static final Integer CACHE_SIZE = 5;
    private static Node head = null;
    private static Node tail = null;

    public static void main(String[] args) {
        addData(new Data(1, "c0Sem1DhZn", System.currentTimeMillis()));
        addData(new Data(2, "qn6a7S3tH7", System.currentTimeMillis()));
        addData(new Data(3, "KzLT1yD", System.currentTimeMillis()));
        addData(new Data(4, "EEZmUqnM0p", System.currentTimeMillis()));
        addData(new Data(5, "apk3Mh5a", System.currentTimeMillis()));
        addData(new Data(6, "1Nn3kp19Zp0", System.currentTimeMillis()));
        addData(new Data(7, "SUNZiivO", System.currentTimeMillis()));
        addData(new Data(8, "cpQGS6gV", System.currentTimeMillis()));
        addData(new Data(9, "bKCqyi3kCI", System.currentTimeMillis()));
        addData(new Data(10, "dNe9eeByn", System.currentTimeMillis()));

        printCache();
        System.out.println();
        getData(1);
        getData(9);
        getData(2);
        getData(3);
        getData(4);
        getData(7);
        printCache();
    }

    public static void addData(Data data) {
        DATA_MAP.put(data.getId(), data);
        addCache(data);
    }

    public static Data getData(Integer id) {
        Node node = CACHE_DATA_MAP.get(id);
        if (node == null) {
            Data data = DATA_MAP.get(id);
            data.setTimestamp(System.currentTimeMillis());
            addCache(data);
            node = tail;
        } else {
            node.data.setTimestamp(System.currentTimeMillis());
            swapNode(node);
        }
        return node.data;
    }

    public static void printCache() {
        for (Map.Entry<Integer, Node> entry : CACHE_DATA_MAP.entrySet()) {
            System.out.println("ID:" + entry.getKey() + " " + entry.getValue().data.getValue() +
                    " " + Instant.ofEpochMilli(entry.getValue().data.getTimestamp()));
        }
    }

    private static void addCache(Data data) {
        Node node = new Node(data);
        CACHE_DATA_MAP.put(data.getId(), node);
        if (head == null) {
            head = node;
        } else {
            tail.right = node;
            node.left = tail;
        }
        tail = node;
        if (CACHE_DATA_MAP.size() > CACHE_SIZE) {
            head = head.right;
            CACHE_DATA_MAP.remove(head.left.data.getId());
            head.left = null;
        }
    }

    private static void swapNode(Node node) {
        if (node.right != null) {
            Node nodeLeft = node.left;
            Node nodeRight = node.right;
            nodeLeft.right = nodeRight;
            nodeRight.left = nodeLeft;
            tail.right = node;
            node.left = tail;
            node.right = null;
            tail = node;
        }
    }

    private static class Node {
        Data data;
        Node left;
        Node right;

        public Node(Data data) {
            this.data = data;
        }
    }
}
