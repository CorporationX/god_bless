package faang.school.godbless.mattersOfTheheart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private final UserList userList = new UserList();
    @Getter
    private final List<Chat> chats = new ArrayList<>();

    public void startChat(User user1) {
        List<User> availableUsers = new ArrayList<>();
        synchronized (userList) {
            while (availableUsers.isEmpty()) {
                availableUsers = userList.getOnlineUser().stream()
                        .filter(user -> user != user1)
                        .filter(user -> user.getChatStatus().equals(UserChatStatus.AVAILABLE))
                        .toList();
                if (availableUsers.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            Chat chat = new Chat();
            User user2 = availableUsers.get(0);
            chat.startChat(user1, user2);
            chats.add(chat);
        }
    }

    public void waitForChat(User user) {
        synchronized (userList) {
            while (chats.stream().noneMatch(chat -> chat.getUserOne().equals(user) || chat.getUserTwo().equals(user))) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            startChat(user);
        }
    }

    public void endChat(User user) {
        List<Chat> chatsToRemove = chats.stream().filter(chat -> chat.getUserOne().equals(user) || chat.getUserTwo().equals(user)).toList();
        synchronized (userList) {
            Chat chatToRemove = chatsToRemove.get(0);
            chatToRemove.closeChat();
            chats.remove(chatToRemove);
            notifyAll();
        }
    }

    public void addUser(User user) {
        userList.addUser(user);
    }
}
