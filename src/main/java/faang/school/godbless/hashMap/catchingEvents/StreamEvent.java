package faang.school.godbless.hashMap.catchingEvents;

import lombok.Data;

@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        if (eventType == null || eventType.isEmpty() || eventType.isBlank()) {
            throw new IllegalArgumentException("Event type can`t be empty");
        }
        if (data == null || data.isEmpty() || data.isBlank()) {
            throw new IllegalArgumentException("Data can`t be empty");
        }
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Event id: " + id + ", type: " + eventType + ", data: " + data;
    }
}
