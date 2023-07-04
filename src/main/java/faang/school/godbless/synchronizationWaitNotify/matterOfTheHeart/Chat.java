package faang.school.godbless.synchronizationWaitNotify.matterOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public boolean containsUser(User user) {
        return user1.equals(user) || user2.equals(user);
    }

    public Optional<Chat> getChatByUser(User user) {
        Chat chat = null;
        if (user1.equals(user) || user2.equals(user)) {
            chat = this;
        }
        return Optional.ofNullable(chat);
    }
}
