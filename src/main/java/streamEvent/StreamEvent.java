package streamEvent;

import lombok.Value;

@Value
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
