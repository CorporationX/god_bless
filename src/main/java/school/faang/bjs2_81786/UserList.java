package school.faang.bjs2_81786;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserList {
    private List<User> users;

    public List<User> getOnlineUsers(User user) {
        return users.stream()
                .filter(u -> u.isEligible() && !u.equals(user))
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
