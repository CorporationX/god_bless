package faang.school.godbless.LRUCache;

import java.util.Date;

@lombok.Data
public class Data {
    private int id;
    private String value;
    private Date timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = new Date();
    }
}
