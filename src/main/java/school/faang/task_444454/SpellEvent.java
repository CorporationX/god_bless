package school.faang.task_444454;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}