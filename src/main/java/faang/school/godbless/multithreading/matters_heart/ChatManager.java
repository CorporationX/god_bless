package faang.school.godbless.multithreading.matters_heart;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ChatManager {
    private List<Chat> chats;
    private UserList userList;
    private static final Object lock = new Object();

    public void startChat(User user1) {
        synchronized (lock) {
            if (user1.isInChat()) {
                System.out.println(user1.getName() + " already in chat");
                return;
            }
            user1.setWantsToChat(true);
            User user2 = waitForChat(user1);
            if (user2 == null) {
                return;
            }
            lock.notify();
            Chat chat = new Chat(user1, user2);
            user1.setChat(chat);
            user2.setChat(chat);
            user1.setInChat(true);
            user2.setInChat(true);
            chats.add(chat);
            System.out.printf("%s starts chat with %s\n", user1.getName(), user2.getName());
        }
    }

    public void endChat(User user) {
        Chat chat = user.getChat();
        if (chats.contains(chat)) {
            chats.remove(chat);
            chat.close();
            System.out.printf("Chat %s - %s ended\n", chat.getUser1().getName(), chat.getUser2().getName());
        } else {
            System.out.println("There are no such chat");
        }
    }

    private User waitForChat(User user1) {
        synchronized (lock) {
            while (user1.isWantsToChat()) {
                User user2 = getUserWantsToChat(user1);
                if (user2 != null) {
                    user1.setWantsToChat(false);
                    user2.setWantsToChat(false);
                    System.out.println(user1.getName() + " found a mate");
                    return user2;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return null;
        }
    }

    private User getUserWantsToChat(User user) {
        return userList.getOnlineUsers().stream()
                .filter(user1 -> !user1.equals(user))
                .filter(User::isWantsToChat)
                .findFirst()
                .orElse(null);
    }
}
