package school.faang.bjs2_68692;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class SpellEvent {
    private final UUID id;
    private final EventType eventType;
    private final String action;
}
