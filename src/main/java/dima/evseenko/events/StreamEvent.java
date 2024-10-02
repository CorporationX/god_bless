package dima.evseenko.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private Long id;
    private EventType eventType;
    private String data;
}
