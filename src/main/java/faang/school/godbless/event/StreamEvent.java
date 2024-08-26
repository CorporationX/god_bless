package faang.school.godbless.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {
    private int id;
    private EventType eventType;
    private String data;
}
