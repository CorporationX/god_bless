package school.faang.task_61509;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class ChatManager {
    private final UserList userList;

    public synchronized void startChat(User user) {
        while (userList.getOnlineUsers().isEmpty()) {
            waitForChat();
        }

        List<User> onlineUsers = userList.getOnlineUsers();

        User otherUser = onlineUsers.stream()
                .filter(u -> !u.equals(user))
                .findFirst()
                .orElse(null);

        if (otherUser == null) {
            log.info("{} could not find another user to chat with", user.getName());
            return;
        }

        Chat chat = new Chat(user, otherUser);
        user.setChatting(true);
        otherUser.setChatting(true);
        user.setChat(chat);
        otherUser.setChat(chat);
        log.info("{} start chat with {}", user.getName(), otherUser.getName());
    }

    public void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        User user1 = chat.getUser1();
        User user2 = chat.getUser2();
        user1.setChatting(false);
        user2.setChatting(false);
        notifyAll();
        log.info("{} end chat with {}", user1.getName(), user2.getName());
    }
}
