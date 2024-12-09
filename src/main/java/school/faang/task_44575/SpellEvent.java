package school.faang.task_44575;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
