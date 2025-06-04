package school.faang.bjs2_79669;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private final Long id;
    private String eventType;
    private String action;
}
