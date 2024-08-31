package faang.school.godbless.BJS2_22592;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {

    private long id;
    private String name;
    private Action actionType;
    private LocalDateTime actionDate;
    private String content;

}
