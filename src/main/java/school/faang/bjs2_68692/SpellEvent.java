package school.faang.bjs2_68692;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class SpellEvent {
    private long id;
    private String eventType;
    private String action;
}
