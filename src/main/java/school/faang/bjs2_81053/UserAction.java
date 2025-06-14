package school.faang.bjs2_81053;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
class UserAction {
    int id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}
