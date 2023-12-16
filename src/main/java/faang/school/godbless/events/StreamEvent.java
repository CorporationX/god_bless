package faang.school.godbless.events;

import lombok.Data;

@Data
public class StreamEvent {
    private static int streamEvenTId = 0;
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = ++streamEvenTId;
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", eventType: " + eventType +
                ", data: " + data;
    }
}
