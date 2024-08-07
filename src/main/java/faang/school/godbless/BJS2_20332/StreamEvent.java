package faang.school.godbless.BJS2_20332;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
public class StreamEvent {
    @Setter
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.eventType = eventType;
        this.data = data;
        this.id = id;
    }
}