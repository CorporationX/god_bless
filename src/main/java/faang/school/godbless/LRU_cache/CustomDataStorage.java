package faang.school.godbless.LRU_cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomDataStorage {

    private final Map<Integer, Node> CACHE = new HashMap<>();
    private final Map<Integer, Data> ALL_DATA = new HashMap<>();
    private final int CACHE_SIZE;
    private static Node head = new Node();
    private static Node tail = new Node();

    public CustomDataStorage(int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    static {
        head.setNext(tail);
        tail.setPrev(head);
    }

    private void addToTail(Node node) {
        node.setPrev(tail);
        tail.setNext(node);
        tail = node;
    }

    private void moveToTail(Node node) {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(null);
        node.setPrev(null);
        addToTail(node);
    }

    private void remove(Node node) {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(null);
        node.setPrev(null);
    }

    private Node removeHead() {
        /*
        Не очень мне нравится эта строчка, я удаляю как бы не head,
        а элемент стоящий через 1 и head при этом не обновляю. Лучше пока что не придумал
        */
        Node prevHead = head.getNext().getNext();
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