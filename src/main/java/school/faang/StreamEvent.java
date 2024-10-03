package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;
}
