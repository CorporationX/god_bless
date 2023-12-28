package faang.school.godbless.lru.cache;

import lombok.Getter;
import lombok.Setter;

public class Node {
    @Getter
    @Setter
    private int key;
    @Getter
    @Setter
    private Data data;
    public Node next;
    public Node prev;

    public Node (int key, Data data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

