package faang.school.godbless.LRU_cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomDataStorage {

    private final Map<Integer, Node> CACHE = new HashMap<>();
    private final Map<Integer, Data> ALL_DATA = new HashMap<>();
    private final int CACHE_SIZE;
    private Node head;
    private Node tail;

    public CustomDataStorage(int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    private void addToTail(Node node) {
        if (head == null) {
            head = node;
        } else if (tail == null) {
            tail = node;
            tail.setPrev(head);
            head.setNext(tail);
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    private void moveToTail(Node node) {
        remove(node);
        addToTail(node);
    }

    private void remove(Node node) {

        if (node == head) {
            node.getNext().setPrev(null);
            head = node.getNext();
        } else {
            node.getNext().setPrev(node.getPrev());
            node.getPrev().setNext(node.getNext());
        }

        node.setNext(null);
        node.setPrev(null);
    }

    private Node removeHead() {
        Node prevHead = head;
        remove(prevHead);
        return prevHead;
    }

    public void addData(Data data) {

        ALL_DATA.put(data.getId(), data);

        if (CACHE.size() == CACHE_SIZE) {
            Node nodeForRemove = removeHead();
            CACHE.remove(nodeForRemove.getData().getId());
        }

        Node node = new Node(data);
        addToTail(node);

        CACHE.put(node.getData().getId(), node);
    }

    public Data getDataById(int id) {
        Node node = CACHE.getOrDefault(id, null);

        if (node == null) {
            node = new Node(ALL_DATA.get(id));

            if (CACHE.size() == CACHE_SIZE) {
                Node nodeForRemove = removeHead();
                CACHE.remove(nodeForRemove.getData().getId());
            }

            addToTail(node);
            CACHE.put(node.getData().getId(), node);
        } else {
            moveToTail(node);
        }

        node.getData().setTimestamp(LocalDateTime.now());

        return node.getData();
    }

    public void printInfoAboutCache() {
        CACHE.values().stream()
                .map(Node::getData)
                .forEach(data -> System.out.printf("%s -> %s%n", data.getId(), data));
    }
}