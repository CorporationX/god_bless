package faang.school.godbless.javahashmap.task11catch_events;

import lombok.Data;

@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
    private static int count = 1;

    public StreamEvent(String eventType, String data) {
        this.id = count++;
        this.eventType = eventType;
        this.data = data;
    }

}
