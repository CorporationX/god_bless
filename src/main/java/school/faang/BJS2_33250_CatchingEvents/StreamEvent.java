package school.faang.BJS2_33250_CatchingEvents;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class StreamEvent {
    private static int count = 0;

    private final int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = ++count;
        setEventType(eventType);
        setData(data);
    }

    private void validateString(String data) {
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("Invalid data.");
        }
    }

    private void setEventType(String eventType) {
        validateString(eventType);
        this.eventType = eventType;
    }

    private void setData(String data) {
        validateString(data);
        this.data = data;
    }
}
