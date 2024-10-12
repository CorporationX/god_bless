package school.faang.BJS2_33283;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;
}
