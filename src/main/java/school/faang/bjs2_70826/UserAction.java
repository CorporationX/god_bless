package school.faang.bjs2_70826;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    long id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}
