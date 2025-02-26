package school.faang.task_61509;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class UserList {
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat() && !user.isChatting())
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
