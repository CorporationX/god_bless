package faang.school.godbless.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
