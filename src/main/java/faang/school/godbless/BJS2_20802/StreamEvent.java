package faang.school.godbless.BJS2_20802;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
