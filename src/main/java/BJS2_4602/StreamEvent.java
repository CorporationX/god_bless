package BJS2_4602;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
