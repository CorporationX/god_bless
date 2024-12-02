package school.faang.bjs244404.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
