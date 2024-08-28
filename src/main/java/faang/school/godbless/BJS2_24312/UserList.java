package faang.school.godbless.BJS2_24312;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserList {
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public User getOnlineAndLookingForChattingUsers(User user) {
        return users
                .stream()
                .filter(userFromList -> !userFromList.equals(user))
                .filter(userFromList -> userFromList.isOnline() && userFromList.isLookingForChat() && !userFromList.isChatting())
                .findAny().orElse(null);
    }
}
