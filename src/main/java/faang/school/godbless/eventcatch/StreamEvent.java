package faang.school.godbless.eventcatch;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
