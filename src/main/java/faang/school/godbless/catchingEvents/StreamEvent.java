package faang.school.godbless.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    int id;
    String eventType;
    String data;
}