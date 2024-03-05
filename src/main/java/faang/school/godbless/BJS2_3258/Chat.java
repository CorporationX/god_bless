package faang.school.godbless.BJS2_3258;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chat {
    private final List<String> messages = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void sendMessage(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public void addUser(User user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        synchronized (users) {
            users.remove(user);
        }
    }
}
