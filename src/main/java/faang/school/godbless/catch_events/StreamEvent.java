package faang.school.godbless.catch_events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
