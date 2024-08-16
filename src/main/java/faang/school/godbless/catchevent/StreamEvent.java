package faang.school.godbless.catchevent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
