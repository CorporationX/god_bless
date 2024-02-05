package faang.school.godbless.eventcatch;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;
}
