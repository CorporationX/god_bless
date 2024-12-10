package school.faang.task_44645;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
