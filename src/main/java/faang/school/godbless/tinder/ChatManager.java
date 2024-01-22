package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    private UserList users;
    private static List<Chat> chats = new ArrayList<>();
    private final Object lock = new Object();

    public ChatManager(UserList userList) {
        this.users = userList;
    }

    public Chat startChat(User user) throws InterruptedException {
        synchronized (lock) {
            Optional<User> u;
            while ((u = users.getOnlineUser()).isEmpty() || u.get().equals(user)) {
                System.out.println("Ожидаем второго пользователя");
                lock.wait();
            }
            User onlineUser = u.get();

            Chat chat = new Chat(user, onlineUser);
            chat.setEmpty(false);
            System.out.println("Пользователь " + onlineUser.getName() + " присоединился к чату");
            System.out.println(chat.getFirstUser().getName() + " " + chat.getSecondUser().getName()
                    + " находятся в чате");
            user.setWaitChat(false);
            onlineUser.setWaitChat(false);

            return chat;
        }
    }

    public void waitForChat(Chat chat) throws InterruptedException {
        synchronized (lock) {
            while (chats.contains(chat)) {
                lock.wait();
            }
        }
        System.out.println("Чат между " + chat.getFirstUser().getName() + " и "
                + chat.getSecondUser().getName() + " начался");
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chat.getFirstUser().setWaitChat(true);
            chat.getSecondUser().setWaitChat(true);
            chats.remove(chat);
            lock.notifyAll();
            System.out.println("Чат между пользователями " + chat.getFirstUser().getName()
                    + " " + chat.getSecondUser().getName() + " завершен");
        }
    }
}
