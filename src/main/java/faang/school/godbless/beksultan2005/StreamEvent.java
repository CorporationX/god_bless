package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class StreamEvent {
    private long id;
    private String eventType;
    private String data;
}
