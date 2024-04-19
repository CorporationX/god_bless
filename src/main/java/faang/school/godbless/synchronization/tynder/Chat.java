package faang.school.godbless.synchronization.tynder;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.synchronization.tynder.ChatManager.userCheck;

public class Chat {
    private final List<User> usersInChat = new ArrayList<>();

    public boolean addUserInChat(User user) {
        if (usersInChat.size() == 2) {
            return false;
        }

        if (user == null) {
            return false;
        }

        usersInChat.add(user);

        return true;
    }

    public boolean hasUser(User user) {
        userCheck(user);

        return usersInChat.contains(user);
    }

    public List<User> getUsersInChat() {
        return usersInChat;
    }
}
