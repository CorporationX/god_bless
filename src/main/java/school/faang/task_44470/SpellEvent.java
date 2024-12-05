package school.faang.task_44470;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class SpellEvent {
    private final Integer id;
    private final String eventType;
    private final String action;
}
