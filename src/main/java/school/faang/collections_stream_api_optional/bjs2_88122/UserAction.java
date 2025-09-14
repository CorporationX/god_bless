package school.faang.collections_stream_api_optional.bjs2_88122;

import java.time.LocalDate;

public record UserAction(
        int userId,
        String userName,
        ActionType actionType,
        LocalDate actionDate,
        String content
){}