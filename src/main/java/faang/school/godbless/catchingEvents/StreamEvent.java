package faang.school.godbless.catchingEvents;

public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;

    public StreamEvent(Integer id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public Integer getId() {
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
        return " Id = " + id + '\n' +
        "EventType = " + eventType + '\n' +
        "Data = " + data + '\n' +
        "_____________________________________________" + '\n';
    }
}
