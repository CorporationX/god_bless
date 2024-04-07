package faang.school.godbless.sprint_1.LRU_cache;

import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
public class Node {
    private Data data;
    private Node next;
    private Node prev;

    public Node(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data.getId() +
                ", next=" + next.data.getId() +
                ", prev=" + prev.data.getId() +
                '}';
    }
}
