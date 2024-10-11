package school.faang.catching.events;

import lombok.ToString;
import lombok.Getter;

@Getter
@ToString
public class StreamEvent {
    private int id;
    private String type, data = "dummy text";

    public StreamEvent(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
