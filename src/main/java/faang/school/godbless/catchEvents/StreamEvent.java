package faang.school.godbless.catchEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StreamEvent {
    int id;
    String eventType;
    String data;

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
