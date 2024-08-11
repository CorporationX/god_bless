package faang.school.godbless.LRU_Chache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Data {
    private int id;
    private String value;
    private long timestamp;
}
