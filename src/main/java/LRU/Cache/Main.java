package LRU.Cache;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Integer CACHE_SIZE;
    @Getter
    private final Map<Integer, Node> cache = new HashMap<>();
    private Node first;
    private Node last;

    public Main(Integer CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    public static void main(String[] args) {
        Main main = new Main(2);

        main.put(1, new Data(1, "qwe1"));
        main.put(2, new Data(2, "qwe2"));
        main.put(3, new Data(3, "qwe3"));
        main.get(1);
        main.get(3);
        main.put(4, new Data(4, "qwe4"));

        main.printInfo();
    }

    public String get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = cache.get(key);
            this.moveToLast(node);
            node.getData().setTimestamp(System.nanoTime());
            return node.getData().getValue();
        }
        Data data = generateData(key);
        put(key, data);

        return data.getValue();
    }

    public void put(int key, Data data) {
        if (this.cache.containsKey(key)) {
            Node node = cache.get(key);
            node.setData(data);
            this.moveToLast(node);
        } else {
            Node node = new Node(data);
            if (this.cache.size() < CACHE_SIZE) {
                this.setLast(node);
            } else {
                this.cache.remove(this.first.getData().getId());
                this.removeFirst();
                this.setLast(node);
            }
            cache.put(key, node);
        }
    }

    public void moveToLast(Node node) {
        if (node != this.last) {
            if (node != this.first) {
                node.getPrevious().getNext().setPrevious(node.getNext());
                node.getNext().getPrevious().setNext(node.getPrevious());
                this.last.setNext(node);
                node.setNext(this.last);
                this.last = node;
                this.last.setNext(null);
            } else {
                Node previewFirst = removeFirst();
                this.last.setNext(previewFirst);
                previewFirst.setPrevious(this.last);
                this.last = previewFirst;
            }
        }
    }

    private Node removeFirst() {
        if (this.first == this.last) {
            this.first = null;
            this.last = null;

            return null;
        } else {
            Node previewFirst = this.first;
            this.first = this.first.getNext();
            this.first.setPrevious(null);

            return previewFirst;
        }
    }

    private void setLast(Node node) {
        if (this.last != null) {
            this.last.setNext(node);
            node.setPrevious(this.last);
        } else {
            this.first = node;
        }

        this.last = node;
    }

    private Data generateData(int id) {
        return new Data(id, "value " + id);
    }

    private void printInfo() {
        for (Map.Entry<Integer, Node> entry : this.cache.entrySet()) {
            System.out.printf("Id: %s,  Значение: %s", entry.getKey(), entry.getValue().getData()).println();
        }
    }
}
