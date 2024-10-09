package school.faang.BJS2_33283;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.data = data;
        this.eventType = eventType;
        this.id = id;
    }
}
