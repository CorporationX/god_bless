package faang.school.godbless.sprint2.tinder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
@ToString
public class UserList {
    private List<User> users;

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }

    public List<User> getWaitingChatUsers() {
        return getOnlineUsers().stream().filter(User::isWaitChat).toList();
    }
}
