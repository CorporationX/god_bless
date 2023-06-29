package faang.school.godbless.tinder;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class UserList {

    private List<User> users = new ArrayList<>();


    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::getIsOnline)
                .collect(Collectors.toList());
    }

    public synchronized void removeFromUserLiked(User user, User userToRemove) {
        if (users.contains(user)) {
            user.removeFromLiked(userToRemove);
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByIndex(int index) {
        return users.get(index);
    }
}
