package faang.school.godbless.catch_events;

import lombok.Data;

@Data
public class StreamEvent {
    private static int startId = 0;
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = startId++;
        this.eventType = eventType;
        this.data = data;
    }

}
