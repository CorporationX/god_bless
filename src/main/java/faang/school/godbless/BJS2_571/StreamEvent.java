package faang.school.godbless.BJS2_571;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StreamEvent {
    private static int count = 0;
    private final int id;
    private String eventType;
    private String data;

    public StreamEvent (String eventType, String data) {
        this.id = ++count;
        this.eventType = eventType;
        this.data = data;
    }
}
