package faang.school.godbless.multithreading.heart_matters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ChatManager {
    private final UserList userList;
    private final List<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        List<User> waitToChatUsers = getWaitToChatUsers(user);
        if (waitToChatUsers.isEmpty()) {
            waitForChat(user);
        }

        if (waitToChatUsers.isEmpty()) {
            return;
        }

        Chat chat = new Chat(user, waitToChatUsers.get(0));
        chats.add(chat);
        chat.startChat();

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        endChat(chat);
    }

    private synchronized void waitForChat(User user) {
        if (!isUserInActiveChat(user)) {
            System.out.println("Waiting for an available chat for " + user.getName());
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private synchronized void endChat(Chat chat) {
        System.out.printf("%s and %s ended the chat\n", chat.getUser1().getName(), chat.getUser2().getName());
        chat.getUser1().setWantsToChat(false);
        chat.getUser2().setWantsToChat(false);
        chats.remove(chat);
        this.notifyAll();
    }

    private List<User> getWaitToChatUsers(User user) {
        return userList.getOnlineUsers(user).stream()
                .filter(User::isWantsToChat)
                .filter(u -> !Objects.equals(u.getId(), user.getId()))
                .toList();
    }

    private boolean isUserInActiveChat(User user) {
        return chats.stream()
                .anyMatch(chat -> Objects.equals(chat.getUser1().getId(), user.getId())
                        || Objects.equals(chat.getUser2().getId(), user.getId()));
    }
}
