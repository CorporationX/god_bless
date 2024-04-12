package faang.school.godbless.streamAPI.userActivity;

import java.time.LocalDateTime;

public record UserAction (int userId,
                          String userName,
                          ActionType actionType,
                          LocalDateTime actionDate,
                          String content){}