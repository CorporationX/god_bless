package faang.school.godbless.JavaHashMap.task5;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class StreamEvent {
    public final int id;
    public final String eventType;
    public final String data ;
}
