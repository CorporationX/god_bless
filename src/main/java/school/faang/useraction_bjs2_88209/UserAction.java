package school.faang.useraction_bjs2_88209;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}

