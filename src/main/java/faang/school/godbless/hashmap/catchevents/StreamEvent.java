package faang.school.godbless.hashmap.catchevents;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
