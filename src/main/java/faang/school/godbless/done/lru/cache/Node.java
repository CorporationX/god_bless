package faang.school.godbless.done.lru.cache;

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

    public Node(int key, Data data) {
        this.key = key;
        this.data = data;
    }
}

