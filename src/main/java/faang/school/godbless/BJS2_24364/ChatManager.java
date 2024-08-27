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

            long amountWaitForChatUsers = onlineUsers.stream()
                    .dropWhile(user::equals)
                    .filter(this::waitForChat)
                    .count();

            if (amountWaitForChatUsers > 0) {
                User secondUser = onlineUsers.stream()
                        .dropWhile(user::equals)
                        .filter(this::waitForChat)
                        .findFirst()
                        .orElseThrow();

                chats.add(new Chat(user, secondUser));
                System.out.println(user + " get new chat with " + secondUser);
                notifyAll();
                return;
            } else {
                try {
                    System.out.println(user + " wait chat");
                    chats.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Wait exception");
                }
            }
        }
        User secondUser = getSecondUserInChat(user);
        System.out.println(user + " get new chat with " + secondUser);
    }

    public synchronized void endChat(User user) {
        if (!waitForChat(user)) {
            User secondUser = getSecondUserInChat(user);
            chats.removeIf(chat -> chat.contains(user));
            notifyAll();
            System.out.println(user + " and " + secondUser + " leave chat");
        }
    }

    private boolean waitForChat(User user) {
        return chats.stream()
                .noneMatch(chat -> chat.contains(user));
    }

    private User getSecondUserInChat(User user) {
        Chat userChat = chats.stream()
                .filter(chat -> chat.contains(user))
                .findFirst()
                .orElseThrow();
        return user.equals(userChat.getUserOne()) ? userChat.getUserTwo() : userChat.getUserOne();
    }
}
