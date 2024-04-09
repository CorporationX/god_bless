package faang.school.godbless.module.hashmap.event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
