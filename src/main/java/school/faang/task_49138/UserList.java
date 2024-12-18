package school.faang.task_49138;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Data
@AllArgsConstructor
public class UserList {
    private final BlockingQueue<User> waitingUsers = new LinkedBlockingQueue<>();
    private static final Random RANDOM = new Random();

    public List<User> getOnlineUsers() {
        return waitingUsers.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .toList();
    }

    public User getRandomUserWantsChat(User user) throws InterruptedException {
        while (true) {
            User matcheingUser = waitingUsers.take();

            if (!matcheingUser.equals(user)) {
                return matcheingUser;
            } else {
                System.out.println("Matched user is the same as the current user");
            }
        }
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }

        if (!waitingUsers.contains(user)) {
            waitingUsers.offer(user);
        }
    }

    public void removeUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        waitingUsers.remove(user);
    }
}
