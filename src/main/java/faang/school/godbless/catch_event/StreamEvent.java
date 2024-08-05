package faang.school.godbless.catch_event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
