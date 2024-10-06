package school.faang.catchtheevents;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class StreamEvent {
    private static int idCounter = 0;
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = ++idCounter;
        this.eventType = eventType;
        this.data = data;
    }
}
