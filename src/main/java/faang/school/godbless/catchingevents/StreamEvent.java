package faang.school.godbless.catchingevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@EqualsAndHashCode
@ToString
public class StreamEvent {
    private static int idFromBD;

    private final int id;
    private final String eventType;
    private final String data;

    public StreamEvent(String eventType, String data) {
        this.id = ++idFromBD;
        this.eventType = eventType;
        this.data = data;
    }
}
