package faang.school.godbless.thematters;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserList {

    private List<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
