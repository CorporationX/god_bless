package faang.school.godbless.sprint3.mattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class ChatManager {
    private final UserList userList;
    private final Set<Chat> chats = new HashSet<>();
    private final Set<User> usersAtChats = new HashSet<>();

    public Chat startChat(User user) throws InterruptedException {
        Chat chat;
        synchronized (userList) {
            waitForChat(user);
            List<User> onlineUsers = userList.getOnlineUsers();
            while (onlineUsers.isEmpty()
                    || (onlineUsers.size() == 1 && onlineUsers.get(0) == user)) {
                System.out.printf("Для пользователя %s собеседник не найден%n", user.getName());
                userList.wait();
                onlineUsers = userList.getOnlineUsers();
            }
            User companion = onlineUsers.get(0) == user ? onlineUsers.get(1) : onlineUsers.get(0);
            System.out.printf("Для пользователя %s найден собеседник %s%n", user.getName(), companion.getName());
            chat = new Chat(user, companion);
            chat.start();
            synchronized (usersAtChats) {
                usersAtChats.add(user);
                usersAtChats.add(companion);
            }
            synchronized (chats) {
                chats.add(chat);
            }
        }
        return chat;
    }

    public void waitForChat(User user) throws InterruptedException {
        synchronized (usersAtChats) {
            while (usersAtChats.contains(user)) {
                usersAtChats.wait();
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            chat.end();
            userList.notifyAll();
        }
        synchronized (chats) {
            chats.remove(chat);
        }
        synchronized (usersAtChats) {
            usersAtChats.remove(chat.getFirstUser());
            usersAtChats.remove(chat.getSecondUser());
            usersAtChats.notifyAll();
        }
    }
}
