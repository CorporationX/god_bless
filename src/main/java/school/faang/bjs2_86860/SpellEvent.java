package school.faang.bjs2_86860;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
