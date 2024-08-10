package faang.school.godbless;

import lombok.Data;
import java.util.UUID;

@Data
public class StreamEvent {
    private String id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        if (eventType == null || data == null) {
            throw new IllegalArgumentException("eventType and data cannot be null");
        }
        this.id = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "id=" + id + ", eventType=" + eventType + ", data=" + data;
    }
}
