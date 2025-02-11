package school.faang.task57212.spells;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;
}
