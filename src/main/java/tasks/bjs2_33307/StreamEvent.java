package tasks.bjs2_33307;

import lombok.Data;

@Data
public class StreamEvent {
    private Integer id;
    private EventType eventType;
    private String data;

    private static int SEQUENCE_ID = 1;

    public StreamEvent(EventType eventType, String data) {
        id = SEQUENCE_ID++;
        this.eventType = eventType;
        this.data = data;
    }

    public String getInformation() {
        return String.format("ID=%d, eventType=%s, data=%s", id, eventType, data);
    }
}
