package faang.school.godbless.tinder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private final UserList userList;
    @Getter
    private final List<Chat> activeChats = new ArrayList<>();
    private final Object lock = new Object();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public void startChat(User user) throws InterruptedException {
        synchronized (lock) {
            user.setOnline(true);
            System.out.println(user.getName() + " wants to join chat");
            List<User> onlineUsers = userList.getOnlineUsers();

            User partner = null;
            for (User onlineUser : onlineUsers) {
                if (!onlineUser.equals(user)) {
                    partner = onlineUser;
                    break;
                }
            }

            if (partner == null) {
                waitForChat(user);
            } else {
                Chat chat = new Chat(user, partner);
                activeChats.add(chat);
                System.out.println(chat);
                lock.notifyAll();

                //chatting
                Thread.sleep(2000);

                endChat(chat);
            }
        }
    }

    public void waitForChat(User user) throws InterruptedException {
        synchronized (lock) {
            for (Chat chat : activeChats) {
                if (chat.getUser1().equals(user) || chat.getUser2().equals(user)) {
                    return;
                }
            }
            System.out.println(user.getName() + " is waiting for a partner");
            lock.wait();
        }
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            activeChats.remove(chat);
            System.out.println("Chat ended between " + chat.getUser1().getName() + " and " + chat.getUser2().getName());
            lock.notifyAll();
        }
    }
}
