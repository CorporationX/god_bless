package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private boolean isOnline;
    private boolean isReadyToCreateChat;
}
