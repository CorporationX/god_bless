package faang.school.godbless.stream_event;

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
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
