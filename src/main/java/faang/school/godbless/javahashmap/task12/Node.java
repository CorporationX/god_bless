package faang.school.godbless.javahashmap.task12;

@lombok.Data
public class Node {
    private int key;
    private Data data;
    private Node nodeRight, nodeLeft;

    public Node(Data data){
        this.key = data.getId();
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}
