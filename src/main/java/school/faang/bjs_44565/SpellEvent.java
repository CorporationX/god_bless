package school.faang.bjs_44565;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpellEvent {
    final int id;
    final String eventType;
    final String actionDescription;

}
