package school.faang.catchEvents;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StreamEvent {
    private final int id;
    private final String eventType;
    private final String data;
}
