package faang.school.godbless.catch_event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
