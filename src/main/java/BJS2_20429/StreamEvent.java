package BJS2_20429;

import lombok.ToString;

@ToString
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
}
