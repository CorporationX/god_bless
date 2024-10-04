package school.faang.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StreamEvent {
    private final Integer id;
    private final String eventType;
    private final String data;
}
