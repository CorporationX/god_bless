package catch_events_BJS2_33299;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}

