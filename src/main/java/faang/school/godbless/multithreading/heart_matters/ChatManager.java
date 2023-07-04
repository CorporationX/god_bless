package faang.school.godbless.multithreading.heart_matters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatManager {
    private final UserList userList;
    private final List<Chat> chats;
    private final Object lock = new Object();

    public ChatManager(UserList userList) {
        this.userList = userList;
        chats = new ArrayList<>();
    }

    public void startChat(User user) {
        synchronized (lock) {
            user.setWantsToChat(true);
            chats.add(new Chat(user, null, this));
            lock.notifyAll();

            Chat chat = getFreeChatForUser(user);
            if (chat == null) {
                waitForChat(user);
            } else {
                chat.startChat();
            }
        }

    }

    public void waitForChat(User user) {
        synchronized (lock) {
            while (true) {
                List<User> wantsToChat = getUsersWantsToChat(userList.getOnlineUsers(user));
                User availableForChat = wantsToChat.stream()
                        .filter(u -> !Objects.equals(u.getId(), user.getId()))
                        .findAny()
                        .orElse(null);
                if (availableForChat != null) {
                    startChat(availableForChat);
                    break;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chats.remove(chat);
            lock.notifyAll();
        }
    }

    private List<User> getUsersWantsToChat(List<User> onlineUsers) {
        return onlineUsers.stream()
                .filter(User::isWantsToChat)
                .toList();
    }

    private Chat getFreeChatForUser(User user) {
        for (Chat chat : chats) {
            if (!(chat.getUser1().equals(user)) && chat.getUser2() == null) {
                return chat;
            }
        }
        return null;
    }
}
