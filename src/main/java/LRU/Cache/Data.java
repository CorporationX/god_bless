package LRU.Cache;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Data {
    private final int id;
    private final String value;
    @Setter
    private long timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp =  System.nanoTime();
    }
}
