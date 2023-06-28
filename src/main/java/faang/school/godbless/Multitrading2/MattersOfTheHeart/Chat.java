package faang.school.godbless.Multitrading2.MattersOfTheHeart;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Chat {
    private final User user;
    private final User target;
    private final List<String> messages = new ArrayList<>();

    public Chat(User user1, User user2) {
        this.user = user1;
        this.target = user2;
    }

    public User getOtherUser(User user) {
        if (user.getName().equals(user.getName())) {
            return target;
        } else {
            return user;
        }
    }

    public boolean getUserInChat(User user) {
        return this.user.getName().equals(user.getName());
    }

}
