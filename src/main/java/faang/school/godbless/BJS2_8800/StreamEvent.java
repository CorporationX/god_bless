package faang.school.godbless.BJS2_8800;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
