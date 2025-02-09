package school.faang.catch_events;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private  int id;
    private String eventType;
    private String action;
}
