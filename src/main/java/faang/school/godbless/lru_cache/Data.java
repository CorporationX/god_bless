package faang.school.godbless.lru_cache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@lombok.Data
public class Data{
    private int id;
    private String value;
    private long timestamp;

    Data(int id, String value, long timestamp){
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }
}
