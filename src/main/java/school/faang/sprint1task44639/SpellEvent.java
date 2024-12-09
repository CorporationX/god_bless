package school.faang.sprint1task44639;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    long id;
    String eventType;
    String action;
}