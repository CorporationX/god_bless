package faang.school.godbless.lru_cache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@lombok.Data
public class DataNode {
    private Data data;
    private DataNode previous;
    private DataNode next;

    public DataNode(Data data) {
        this.data = data;
    }
}
