package school.faang.analysuseractivsocialnet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class UserAction {
    private int userId;
    private String userName;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
