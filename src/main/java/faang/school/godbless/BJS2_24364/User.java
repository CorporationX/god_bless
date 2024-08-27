package faang.school.godbless.BJS2_24364;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private final String name;
    @EqualsAndHashCode.Exclude
    private boolean isOnline;
    @EqualsAndHashCode.Exclude
    private boolean isWantToChat;
}
