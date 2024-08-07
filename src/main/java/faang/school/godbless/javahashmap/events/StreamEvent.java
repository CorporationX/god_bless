package faang.school.godbless.javahashmap.events;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}

