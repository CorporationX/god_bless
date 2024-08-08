package faang.school.godbless.LRUCache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@EqualsAndHashCode
@AllArgsConstructor
@Setter
@Getter
public class Data {
    private int id;
    private int value;
    private Calendar timestamp;
}
