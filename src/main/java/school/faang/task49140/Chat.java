package school.faang.task49140;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Chat {
    @Setter
    private boolean chatActive = false;
    private User user1;
    @Setter
    private User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
