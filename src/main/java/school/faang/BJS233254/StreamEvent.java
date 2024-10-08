package school.faang.BJS233254;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private EventType event;
    private String data;
}
