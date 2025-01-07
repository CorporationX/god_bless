package derschrank.sprint03.task13.bjstwo_49141;

import java.util.List;

public interface UserListInterface {
    List<User> getOnlineUsersAwaitForNewChat();

    void addUser(User user);

    void removeUser(User user);

}
