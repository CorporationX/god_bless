package school.faang.sprint_1.task_44687;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
