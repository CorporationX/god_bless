package school.faang.bjs2_81766_matters_of_heart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class UserList {
    private final List<User> userList = new ArrayList<>();

    public synchronized List<User> getOnlineUsers() {
        return userList.stream()
                .filter(User::isOnline)
                .toList();
    }

    public synchronized List<User> getOnlineUsersForChat() {
        return userList.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat())
                .toList();
    }

    public synchronized Optional<User> getRandomPartner(User user) {
        List<User> availableUsers = userList.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat() && !u.equals(user))
                .toList();
        if (availableUsers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(availableUsers.get(
                ThreadLocalRandom.current().nextInt(0,
                        availableUsers.size()))
        );
    }

    public synchronized void addUser(User user) {
        userList.add(user);
        log.info("Added user {} to user list.", user.getName());
        notifyAll();
    }

    public synchronized void removeUser(User user) {
        userList.remove(user);
        log.info("Removed user {} from user list.", user.getName());
    }
}
