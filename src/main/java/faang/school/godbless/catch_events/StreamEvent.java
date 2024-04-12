package faang.school.godbless.catch_events;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
public class StreamEvent {
    @Getter
    private int id;
    @Getter
    private String eventType;
    @Getter
    private String data;

    @Override
    public String toString() {
        return "(id: " + id + ", eventType: " + eventType + ", data: " + data + ")";
    }
}

