package school.faang.collections_stream_optional_2_2.bjs2_70890;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
