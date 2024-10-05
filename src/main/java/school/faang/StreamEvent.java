package school.faang;

import java.util.Objects;

public class StreamEvent {
    private static int idCounter = 0;
    private final int id;
    private final String eventType;
    private final String data;

    public StreamEvent(String eventType, String data) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать тип события");
        }
        if (data == null) {
            throw new IllegalArgumentException("Необходимо указать данные события");
        }

        this.id = nextId();
        this.eventType = eventType;
        this.data = data;
    }

    private int nextId() {
        return idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StreamEvent streamEvent = (StreamEvent) obj;
        return id == streamEvent.id &&
                eventType.equals(streamEvent.eventType) &&
                data.equals(streamEvent.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, data);
    }

    @Override
    public String toString() {
        return "StreamEvent id: " + id + ", eventType: " + eventType + ", data: " + data;
    }

}
