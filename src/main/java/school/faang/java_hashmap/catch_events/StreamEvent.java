package school.faang.java_hashmap.catch_events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;

    public StreamEvent(Integer id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getEventType() {
        return eventType;
    }

    public Integer getId() {
        return id;
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
