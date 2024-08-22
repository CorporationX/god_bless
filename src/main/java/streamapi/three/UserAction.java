package streamapi.three;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserAction {

    private int userId;
    private String userName;
    private ActionType actionType;
    private final LocalDateTime actionDate = LocalDateTime.now();
    private String content;

}
