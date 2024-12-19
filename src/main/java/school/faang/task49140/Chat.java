package school.faang.task49140;

import lombok.Getter;

@Getter
public class Chat {
    private boolean chatActive = false;
    private User user1;
    private User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
