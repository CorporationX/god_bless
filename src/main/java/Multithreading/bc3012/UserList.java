package Multithreading.bc3012;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserList {
    private List<User> users;

    public synchronized void addUsersToChat(User user1, User user2) {
        users.remove(user1);
        users.remove(user2);
    }

    public synchronized void addUsersToList(Chat chat) {
        users.add(chat.getUser1());
        users.add(chat.getUser2());
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
