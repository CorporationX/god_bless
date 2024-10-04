package catchEvents;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class StreamEvent {
    private static int count = 0;

    private final int id;
    private final String eventType;
    private final String data;

    public StreamEvent(String eventType, String data) {
        this.eventType = eventType;
        this.data = data;
        this.id = ++count;
    }
}
