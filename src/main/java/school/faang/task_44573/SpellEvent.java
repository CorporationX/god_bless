package school.faang.task_44573;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String eventDescription;
}
