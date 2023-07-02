package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;
    private String chatId;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.chatId = user1.getUsername() + "-" + user2.getUsername();
    }
}
