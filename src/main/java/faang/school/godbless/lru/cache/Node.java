package faang.school.godbless.lru.cache;

public class Node {
    int key;
    Data data;
    Node next = null;
    Node prev = null;

    public Node(){};

    public Node(int key, Data data) {
        this.key = key;
        this.data = data;
    }
}
