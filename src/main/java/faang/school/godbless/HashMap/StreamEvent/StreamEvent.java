package src.main.java.faang.school.godbless.HashMap.StreamEvent;

public class StreamEvent {
    int id;
    String eventType;
    String data;

    StreamEvent(int id, String eventType, String data) {
        this.data = data;
        this.eventType = eventType;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
