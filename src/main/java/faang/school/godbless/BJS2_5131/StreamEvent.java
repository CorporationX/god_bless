package faang.school.godbless.BJS2_5131;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
