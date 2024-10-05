package HashMap_events;

import lombok.Getter;

@Getter
public class StreamEvent {
    private final int id;
    private final String eventType;
    private final String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }
}
