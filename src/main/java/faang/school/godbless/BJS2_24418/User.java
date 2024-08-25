package faang.school.godbless.BJS2_24418;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private final int userId;
    private final String name;
    private boolean isOnline = false;
    private boolean wantToChat = false;
}
