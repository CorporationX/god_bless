package faang.school.godbless.stream.analysis;

import java.time.LocalDateTime;

public record UserAction(String userId, String name, ActionType actionType, LocalDateTime actionDate, String content) {
}
