package bjs2_35748;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserList {
    Queue<User> users;

    public Queue<User> getOnlineUsersExcludingUser(User userToExclude) {
        return users.stream()
                .filter(user -> !user.equals(userToExclude))
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        if (!users.contains(user)) {
            System.out.println("User does not exist");
        } else {
            users.remove(user);
        }
    }
}
