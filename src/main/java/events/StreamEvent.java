package events;

import lombok.Data;

@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", eventType='" + eventType + '\'' +
                        ", data='" + data + '\'' +
                        '}';
    }
}