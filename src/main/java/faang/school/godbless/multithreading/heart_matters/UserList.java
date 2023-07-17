package faang.school.godbless.multithreading.heart_matters;

import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserList {
    private List<User> users;

    public List<User> getOnlineUsers(User user) {
        return users.stream()
                .filter(u -> !Objects.equals(u.getId(), user.getId()))
                .filter(User::isOnline)
                .toList();
    }
}
