package faang.school.godbless.javahashmap.task10;

@lombok.Data
public class Node {
    int key;
    Data data;
    Node nodeRight, nodeLeft;

    public Node(Data data){
        this.key = data.getId();
        this.data = data;
    }

    public Node(int key, Data data){
        this.key = key;
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
