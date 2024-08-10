package events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class StreamEvent {
    private Integer id;
    private EventType eventType;
    private String data;
}
