package faang.school.godbless.BJS2_24364;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class ChatManager {
    private final List<Chat> chats = new ArrayList<>();
    private final UserList users;

    public synchronized void startChat(User user) {
        System.out.println(user + " search chat");

        while (waitForChat(user)) {
            List<User> onlineUsers = users.getOnlineUsers();
            long amountWaitForChatUsers = countWaitForChatUser(onlineUsers);
            if (amountWaitForChatUsers > 1) {
                User secondUser = onlineUsers.stream()
                        .dropWhile(user::equals)
                        .filter(this::waitForChat)
                        .findFirst()
                        .orElseThrow();
                chats.add(new Chat(user, secondUser));
                System.out.println(user + " get new chat with " + secondUser);
                this.notifyAll();
                return;
            } else {
                try {
                    System.out.println(user + " wait chat");
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Wait exception");
                }
            }
        }
        User secondUser = getSecondUserInChats(user);
        System.out.println(user + " get new chat with " + secondUser);
    }

    public synchronized void endChat(User user) {
        if (!waitForChat(user)) {
            User secondUser = getSecondUserInChats(user);
            chats.removeIf(chat -> chat.contains(user));
            this.notifyAll();
            System.out.println(user + " and " + secondUser + " leave chat");
        }
    }

    private boolean waitForChat(User user) {
        return chats.stream()
                .noneMatch(chat -> chat.contains(user));
    }

    private long countWaitForChatUser(List<User> onlineUsers) {
        return onlineUsers.stream()
                .filter(this::waitForChat)
                .count();
    }

    private User getSecondUserInChats(User user) {
        Chat userChat = chats.stream()
                .filter(chat -> chat.contains(user))
                .findFirst()
                .orElseThrow();
        return user.equals(userChat.getUserOne()) ? userChat.getUserTwo() : userChat.getUserOne();
    }
}
