package faang.school.godbless.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    @Override
    public String toString() {
        return "id: " + id +
                ", eventType: " + eventType +
                ", data: " + data;
    }
}
