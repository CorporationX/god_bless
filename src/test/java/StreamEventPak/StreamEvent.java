package StreamEventPak;

import java.util.Objects;

public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamEvent that = (StreamEvent) o;
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, data);
    }

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
