package school.faang.task_44645;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
