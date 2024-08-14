package LRU.Cache;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Node {
    private Data data;
    private Node previous;
    private Node next;

    public Node(Data data) {
        this.data = data;
    }
}