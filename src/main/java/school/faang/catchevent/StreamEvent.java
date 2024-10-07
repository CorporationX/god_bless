package school.faang.catchevent;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private String id;
    private String eventType;
    private String data;

    public StreamEvent(String data, String eventType) {
        this.data = data;
        this.eventType = eventType;
    }
}
