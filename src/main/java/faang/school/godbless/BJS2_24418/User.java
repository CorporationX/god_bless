package faang.school.godbless.BJS2_24418;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public class User {
    private final int userId;
    private final String name;
    private boolean isOnline = false;
    private boolean isChatting = false;
    private Chat chat;
}
