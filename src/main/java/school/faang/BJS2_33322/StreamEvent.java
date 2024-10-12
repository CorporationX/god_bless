package school.faang.BJS2_33322;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
