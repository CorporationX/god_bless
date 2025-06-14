package school.faang.bjs2_81053;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
class UserAction {
    int id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}
