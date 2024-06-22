package faang.school.godbless.multithreading_synchronization.task_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatManager {
    private final List<Chat> chats = new ArrayList<>();

    private static final int CHAT_TIME_CREATION_MS = 3000;

    public synchronized void startChat(User user, String message) {
        final UserList userList = new UserList();
        final List<User> onlineUsers = userList.getOnlineUsers();
        if (onlineUsers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while waiting for users to be online", e);
            }
        }
        final User otherUser = onlineUsers.get(new Random().nextInt(onlineUsers.size()));
        System.out.printf("Starting chat with users: %s and %s with message: %s\n", user.getName(), otherUser.getName(), message);
        try {
            Thread.sleep(CHAT_TIME_CREATION_MS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while waiting for chat to be created", e);
        }
        chats.add(new Chat(user, otherUser, message));
        notifyAll();
    }

    public synchronized void waitForChat(User user) {
        if (!anyChatContainUser(user)) {
            try {
                System.out.printf("User: %s is waiting for chat to be online\n", user.getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void stopChat(User user) {
        if (!anyChatContainUser(user)) {
            throw new IllegalArgumentException("User is not chatting");
        }
        removeChat(user);
        System.out.printf("Removed chat with user: %s\n", user.getName());
        notifyAll();
    }

    private void removeChat(User user) {
        final Chat filteredChat = chats.stream()
                .filter(chat -> user == chat.getCurrentUser() || user == chat.getTargetUser())
                .findFirst()
                .orElseThrow();
        chats.remove(filteredChat);
    }

    private boolean anyChatContainUser(User user) {
        return chats.stream().anyMatch(chat -> user == chat.getCurrentUser() || user == chat.getTargetUser());
    }
}
