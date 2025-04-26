package school.faang.tinder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private final String name;
    @Setter
    private boolean isOnline = true;
    @Setter
    private boolean isLookingForChat = false;
}
