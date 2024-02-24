package faang.school.godbless.thematters;

import java.util.HashSet;
import java.util.Set;

public class ChatManager {

    private UserList users;
    private Set<Chat> chats = new HashSet<>();
    private final Object LOCK = new Object();

    public ChatManager(UserList users) {
        this.users = users;
    }

    public void startChat(User user) {
        validateUser(user);
        System.out.println(String.format("User \"%s\" is wants to chat", user.getName()));
        synchronized (LOCK) {
            User readyToTalkUser = getReadyToTalkUser(user);
            while (readyToTalkUser == null) {
                waitForChat(user);
                readyToTalkUser = getReadyToTalkUser(user);
            }
            if (user.getChat() == null) {
                createChat(user, readyToTalkUser);
                System.out.println(String.format("User \"%s\" starts chat with user \"%s\"", user.getName(), readyToTalkUser.getName()));
            }
        }
    }

    public void endChat(User user) {
        validateUser(user);
        synchronized (LOCK) {
            Chat chat = user.getChat();
            removeChat(chat);
            LOCK.notifyAll();
            System.out.println(String.format("User \"%s\" ends chat with user \"%s\"", chat.getUser1().getName(), chat.getUser2().getName()));
        }
    }

    private void createChat(User user1, User user2) {
        validateUser(user1, user2);
        Chat chat = new Chat(user1, user2);
        user1.setChat(chat);
        user2.setChat(chat);
        chats.add(chat);
    }

    private void removeChat(Chat chat) {
        User user1 = chat.getUser1();
        User user2 = chat.getUser2();
        user1.setChat(null);
        user2.setChat(null);
        chats.remove(chat);
    }

    private void waitForChat(User user) {
        if (user.getChat() == null) {
            synchronized (LOCK) {
                try {
                    System.out.println(String.format("User \"%s\" is waiting partner", user.getName()));
                    LOCK.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private User getReadyToTalkUser(User user) {
        validateUser(user);
        return users.getOnlineUsers().stream()
                .filter(User::isWantsToChat)
                .filter(onlineUser -> !onlineUser.equals(user))
                .filter(onlineUser -> onlineUser.getChat() == null)
                .findAny().orElse(null);
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can't be null");
        }
    }

    private void validateUser(User user1, User user2) {
        if (user1 == null || user2 == null) {
            throw new IllegalArgumentException("User can't be null");
        }
    }
}
