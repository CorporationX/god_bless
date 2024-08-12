package faang.school.godbless.bjs2_20397;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class StreamEvent {
    private Integer id;
    private EventType eventType;
    private String data;
}
