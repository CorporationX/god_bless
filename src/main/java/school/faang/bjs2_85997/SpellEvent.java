package school.faang.bjs2_85997;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class SpellEvent {
    private String id;
    private String eventType;
    private String action;
}
