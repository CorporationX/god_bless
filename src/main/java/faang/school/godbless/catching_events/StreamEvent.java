package faang.school.godbless.catching_events;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
