package school.faang.BJS2_29019;

import lombok.Data;

@Data
public class StreamEvent {
    private static Integer counter = 0;
    private Integer id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = counter++;
        this.eventType = eventType;
        this.data = data;
    }
}
