package faang.school.godbless.r_edzie.hashmaps.events;

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
}
