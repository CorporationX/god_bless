package faang.school.godbless.lru_cache;

@lombok.Data
public class DataNode {
    private Data data;
    private DataNode parent;
    private DataNode leftChild;
    private DataNode rightChild;

    public DataNode(Data data) {
        this.data = data;
    }
}
