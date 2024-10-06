package school.faang.hashmap.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private Object data;
}
