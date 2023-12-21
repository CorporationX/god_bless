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
    public Node next = null;
    public Node prev = null;

    public Node () {
    }

    public Node (int key, Data data) {
        this.key = key;
        this.data = data;
    }
}

