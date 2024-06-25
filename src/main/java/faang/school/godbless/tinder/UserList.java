package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@AllArgsConstructor
@Setter
@Getter
public class UserList {
    private List<User> allUsers = new ArrayList<>();
    private final Queue<User> waitingUsers = new LinkedList<>();

    public synchronized void waitForChat(User user) {
        if (waitingUsers.contains(user)) {
            return;
        }

        waitingUsers.add(user);
        this.notifyAll();
    }

    List<User> getOnlineUsers() {
        return allUsers.stream().filter(User::isOnline).toList();
    }
}
