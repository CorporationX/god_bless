package faang.school.godbless.BJS2_20309;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Node> dataMap = new HashMap<>();
    private ExternalDataSource externalDataSource;
    private Node first;
    private Node last;

    private final Integer CACHE_SIZE;

    public LRUCache(Integer CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    private static class Node {
        private Data data;
        private Node next;
        private Node previous;
        private Node(Data data) {
            this.data = data;
        }
    }

    public Integer getSize() {
        return dataMap.size();
    }

    public void setExternalDataSource(ExternalDataSource externalDataSource) {
        this.externalDataSource = externalDataSource;
    }

    public Data get(int id) {
        Node node = dataMap.get(id);
        if (node == null) {
            Data data = externalDataSource.getData(id);
            if (data == null) {
                return null;
            }
            put(id, data);
            return data;
        }

        if (node == first) {
            node.next.previous = null;
            first = node.next;
            last.next = node;
            node.next = null;
            node.previous = last;
            last = node;
            node.data.setTimestamp(LocalDateTime.now());
            return node.data;
        } else if (node == last) {
            node.data.setTimestamp(LocalDateTime.now());
            return node.data;
        }

        node.previous.next = node.next;
        node.next.previous = node.previous;
        last.previous.next = node;
        node.next = null;
        last = node;
        node.data.setTimestamp(LocalDateTime.now());

        return node.data;
    }

    public void put(int id, Data data) {
        if (dataMap.containsKey(id)) {
            get(id);
            return;
        }
        data.setTimestamp(LocalDateTime.now());
        if (dataMap.size() == 0) {
            Node insertedNode = new Node(data);
            first = insertedNode;
            last = insertedNode;
            dataMap.put(id, insertedNode);
        } else if (dataMap.size() < CACHE_SIZE) {
            putAndChangeLinks(id, data);
        } else {
            var node = dataMap.remove(first.data.getId());
            first = node.next;
            first.previous = null;
            putAndChangeLinks(id, data);
        }
    }

    private void putAndChangeLinks(int id, Data data) {
        Node insertedNode = new Node(data);
        last.next = insertedNode;
        insertedNode.previous = last;
        last = insertedNode;
        dataMap.put(id, insertedNode);
    }

    public void print() {
        dataMap.values().stream()
                .map(node -> node.data)
                .sorted(Comparator.comparing(Data::getTimestamp).reversed())
                .forEach(System.out::println);
    }
}
