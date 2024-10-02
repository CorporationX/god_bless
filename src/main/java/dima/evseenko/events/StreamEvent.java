package dima.evseenko.events;

import lombok.Data;

@Data
public class StreamEvent {
    private Long id;
    private EventType eventType;
    private Object data;
}
