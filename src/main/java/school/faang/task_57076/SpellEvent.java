package school.faang.task_57076;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class SpellEvent {
    private UUID id;
    private String eventType;
    private String action;
}
