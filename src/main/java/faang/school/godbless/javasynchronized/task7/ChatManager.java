package faang.school.godbless.javasynchronized.task7;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ChatManager {
    private List<Chat> chats = new ArrayList<>();
    private UserList userList;
    private final Object lock = new Object();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public void startChat(User user) {
        synchronized (lock) {
            if (user.getChat() != null || !user.isOnline()) {
                return;
            }
            List<User> wantToStartUsers = getWantToStartUsers(user);
            while (wantToStartUsers.size() == 0) {
                waitForChat(user);
                wantToStartUsers = getWantToStartUsers(user);
            }
            Chat chat = new Chat(user, wantToStartUsers.get(0));
            chats.add(chat);
            System.out.println("Чат создан: " + chat.getFirtstUser().getName() + " - " +
                    chat.getSecondUser().getName());
            wantToStartUsers.get(0).setChat(chat);
            user.setChat(chat);
        }
    }

    private void waitForChat(User user) {
        synchronized (lock) {
            if (user.getChat() == null) {
                System.out.println(user.getName() + " ожидает общения");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chat.getFirtstUser().setChat(null);
            chat.getSecondUser().setChat(null);
            chats.remove(chat);
            System.out.println("Чат завершен: " + chat.getFirtstUser().getName() + " - " + chat.getSecondUser().getName());
            lock.notifyAll();
        }
    }

    private List<User> getWantToStartUsers(User user) {
        synchronized (lock) {
            return userList.getUsers().stream()
                    .filter(currentUser -> currentUser.isOnline() && !user.getName().equals(currentUser.getName()))
                    .filter(currentUser -> currentUser.getChat() == null)
                    .toList();
        }
    }
}
