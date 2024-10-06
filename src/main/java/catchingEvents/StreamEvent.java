package catchingEvents;

import lombok.Data;

@Data
public class StreamEvent {
    static int counter = 0;
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = ++counter;
        this.eventType = eventType;
        this.data = data;
    }
}


