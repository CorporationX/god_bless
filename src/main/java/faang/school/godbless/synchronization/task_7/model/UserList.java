package faang.school.godbless.synchronization.task_7.model;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserList {
    private final List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .collect(Collectors.toList());
    }
}