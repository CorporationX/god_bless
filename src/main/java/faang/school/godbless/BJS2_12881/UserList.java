package faang.school.godbless.BJS2_12881;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public boolean isWantsToChat() {
        return users.stream().anyMatch(User::isWantsChatting);
    }

    public List<User> getWantsToChatUser(User user) {
        return users.stream()
                .filter(u -> u.isAvailableForChat() && !u.equals(user))
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
