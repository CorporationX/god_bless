package school.faang.catching.events;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Event {
    private int id;
    private String eventType;
    private String data;

    public Event(int id, String eventType, String data) {
        if (id < 0) {
            throw new IllegalArgumentException("Id не может быть отрицательным");
        }
        if (eventType == null || eventType.isEmpty() || eventType.isBlank()) {
            throw new IllegalArgumentException("eventType не может быть пустым");
        }
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("data не может быть пустым");
        }
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }
}
