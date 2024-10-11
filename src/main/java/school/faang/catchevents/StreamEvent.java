package school.faang.catchevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }
    public StreamEvent(){

    };
}
