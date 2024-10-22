package school.faang.catchEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;
}
