package school.faang.bjs2_88243;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    public ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
