package school.faang.bjs249194;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class UserList {
    private final Set<User> users = new LinkedHashSet<>();

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }

    public List<User> getOnlineAndLookingForChatUsers() {
        return getOnlineUsers().stream().filter(User::isLookingForChat).toList();
    }

    public synchronized void addUserToSearch(User user) {
        user.setLookingForChat(true);
        users.add(user);
        this.notifyAll();
        log.info("New user available! {}", user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }
}
