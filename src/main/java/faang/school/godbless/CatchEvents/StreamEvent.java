package faang.school.godbless.CatchEvents;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
