package faang.school.godbless.streamEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
