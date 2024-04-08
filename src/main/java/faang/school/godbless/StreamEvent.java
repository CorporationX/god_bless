package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class StreamEvent {
    @Getter
    private int id;
    @Getter
    private String eventType;
    @Getter
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "(id: " + id + ", eventType: " + eventType + ", data: " + data + ")";
    }
}

