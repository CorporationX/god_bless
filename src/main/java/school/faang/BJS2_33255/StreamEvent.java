package school.faang.BJS2_33255;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
