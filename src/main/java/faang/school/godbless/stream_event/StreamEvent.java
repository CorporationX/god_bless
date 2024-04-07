package faang.school.godbless.stream_event;

import lombok.ToString;

@ToString(includeFieldNames=true)
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

}
