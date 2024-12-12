package school.faang.task_44579;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;
}
