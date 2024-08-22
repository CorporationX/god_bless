package faang.school.godbless.secondsprint.socialnetwork;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private long id;
    private String name;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;
}
