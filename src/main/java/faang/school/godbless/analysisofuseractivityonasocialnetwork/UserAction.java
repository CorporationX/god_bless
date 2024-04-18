package faang.school.godbless.analysisofuseractivityonasocialnetwork;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
public class UserAction {
    private final UUID userId;
    private final String name;
    private final UserActionType actionType;
    private final LocalDateTime actionDate;
    private final String content;
}
