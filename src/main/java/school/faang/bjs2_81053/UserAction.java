package school.faang.bjs2_81053;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
