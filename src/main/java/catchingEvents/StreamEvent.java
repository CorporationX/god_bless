package catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
    private static int counterId = 1;

    public StreamEvent(String eventType, String data) {
        this.id = counterId;
        this.eventType = eventType;
        this.data = data;
        counterId++;
    }
}
