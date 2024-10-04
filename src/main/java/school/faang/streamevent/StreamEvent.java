package school.faang.streamevent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    int id;
    String eventType;
    String data;
}
