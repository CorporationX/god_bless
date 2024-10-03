package school.faang.catchingevents.classes;

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