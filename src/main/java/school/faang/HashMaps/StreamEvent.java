package school.faang.HashMaps;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
