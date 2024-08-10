package faang.school.godbless.LRU;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@ToString
public class Data implements Serializable{
    private Long id;
    private Long value;
    @Setter
    private Date timestamp;

    public Data(Long id, Long value) {
        this.id = id;
        this.value = value;
        timestamp = new Date();
    }
}
