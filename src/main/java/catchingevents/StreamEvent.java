package catchingevents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class StreamEvent {
    @Getter
    private int id;
    @Getter
    private String eventType;
    private String data;
}
