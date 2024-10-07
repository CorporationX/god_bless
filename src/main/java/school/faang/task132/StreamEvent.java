package school.faang.task132;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class StreamEvent {

    @Getter
    private int id;
    @Getter
    private String eventType;
    private String data;
}
