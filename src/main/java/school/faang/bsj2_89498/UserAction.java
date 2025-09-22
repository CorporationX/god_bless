package school.faang.bsj2_89498;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    private Actions actionType;
    private LocalDate actionDate;
    private String content;
}
