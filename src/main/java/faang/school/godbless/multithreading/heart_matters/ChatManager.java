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
        user.setWantsToChat(true);
        this.notifyAll();

        List<User> waitToChatUsers = getWantsToChatUsers(user);

        if (waitToChatUsers.isEmpty()) {
            System.out.println("There are no users want to chat");
            waitForChat(user);
        } else {
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
    }

    public synchronized void waitForChat(User user) {
        Chat activeChatWithUser = getAvailableChatForUser(user);

        if (activeChatWithUser == null) {
            System.out.println("Waiting for an available chat for " + user.getName());
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public synchronized void endChat(Chat chat) {
        System.out.printf("%s and %s ended the chat\n", chat.getUser1().getName(), chat.getUser2().getName());
        chat.getUser1().setWantsToChat(false);
        chat.getUser2().setWantsToChat(false);
        chats.remove(chat);
        this.notifyAll();
    }

    private List<User> getWantsToChatUsers(User user) {
        return userList.getOnlineUsers(user).stream()
                .filter(User::isWantsToChat)
                .filter(u -> !Objects.equals(u.getId(), user.getId()))
                .toList();
    }

    private Chat getAvailableChatForUser(User user) {
        return chats.stream()
                .filter(chat -> Objects.equals(chat.getUser1().getId(), user.getId())
                        || Objects.equals(chat.getUser2().getId(), user.getId()))
                .findAny()
                .orElse(null);
    }
}
