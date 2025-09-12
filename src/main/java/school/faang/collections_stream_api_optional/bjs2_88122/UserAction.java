package school.faang.collections_stream_api_optional.bjs2_88122;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}