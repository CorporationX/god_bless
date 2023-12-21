package faang.school.godbless.multi.task9tinder;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class ChatManager {
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();

    public synchronized void startChat(User user) throws InterruptedException {
        user.setAvailableForChat(true);
        System.out.println(user.getName() + " ожидает пользователся для беседы...");
        while (!findChatForUser(user)) {
            wait();
        }
    }

    private boolean findChatForUser(User user) {
        if (user.isAvailableForChat()) {
            List<User> onlineUsers = userList.getOnlineUsers();
            for (User onlineUser : onlineUsers) {
                if (onlineUser.isAvailableForChat() && !onlineUser.equals(user)) {
                    Chat chat = new Chat(user, onlineUser);
                    activeChats.add(chat);
                    onlineUser.setAvailableForChat(false);
                    user.setAvailableForChat(false);
                    notifyAll();
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized void endChatForUser(User user) {
        for (Iterator<Chat> iterator = activeChats.iterator(); iterator.hasNext(); ) {
            Chat chat = iterator.next();
            if (chat.containsUser(user)) {
                iterator.remove();
                System.out.println("Переписка была закончена между " + chat.getUser1().getName() + " и " + chat.getUser2().getName());
                notifyAll();
                break;
            }
        }
    }

    public void simulateChat(User user) {
        new Thread(() -> {
            try {
                startChat(user);
                Thread.sleep(4000);
                endChatForUser(user);
            } catch (InterruptedException e) {
                System.out.println("Переписка прервана");
            }
        }).start();
    }
}
