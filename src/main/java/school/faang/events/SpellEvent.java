package school.faang.events;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}

