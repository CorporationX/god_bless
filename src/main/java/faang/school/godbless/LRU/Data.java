package faang.school.godbless.LRU;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@ToString
@Setter
@EqualsAndHashCode//нужно для сверки множеств в тестах
public class Data implements Serializable{
    private Long id;
    private Long value;
    private Date timestamp;

    public Data(Long id, Long value) {
        this.id = id;
        this.value = value;
        timestamp = new Date();
    }
}
