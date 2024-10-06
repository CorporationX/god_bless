package school.faang.catch_ivents_BJS2_33206;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private String id;
    private String eventType;
    private String data;
}
