package faang.school.godbless.synchronizationWaitNotify.matterOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserList {
    private List<User> userList;

    public synchronized List<User> getOnlineUsers(User user) {
        return userList.stream()
                .filter(User::isOnline)
                .filter(userOnline -> !userOnline.equals(user))
                .toList();
    }

    public synchronized void addUserToAvailable(User user) {
        user.setOnline(true);
    }

    public synchronized void removeUserFromAvailable(User user) {
        user.setOnline(false);
    }
}
