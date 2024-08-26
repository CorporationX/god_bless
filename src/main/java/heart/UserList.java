package heart;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserList {
    private final List<User> users;

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
