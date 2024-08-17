package faang.school.godbless.lrucache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int key;
    private Data value;
    private Node left;
    private Node right;

    public Node(int key, Data value) {
        this.key = key;
        this.value = value;
    }
}