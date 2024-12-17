package school.faang.task_49138;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class UserList {
    private List<User> users;
    private static final Random RANDOM = new Random();

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .toList();
    }

    public synchronized User getRandomUserWantsChat(User user) throws InterruptedException {
        List<User> availableUsers = getOnlineUsers();
        System.out.println("Checking available users...");

        List<User> filteredUsers = availableUsers.stream()
                .filter(u -> !u.equals(user))
                .toList();

        if (filteredUsers.isEmpty()) {
            System.out.println("No available users for chat");
            wait();
        }

        int id = RANDOM.nextInt(filteredUsers.size());
        return filteredUsers.get(id);
    }

    public synchronized void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        if (!users.contains(user)) {
            users.add(user);
            notifyAll();
        }
    }

    public synchronized void removeUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        users.remove(user);
    }
}
