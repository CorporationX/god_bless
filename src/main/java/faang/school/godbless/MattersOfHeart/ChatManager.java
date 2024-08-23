package faang.school.godbless.MattersOfHeart;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private static int id = 0;
    public static UserList users = new UserList();
    public static final List<Chat> CHATS_ONLINE = new ArrayList<>();

    private final List<User> usersOnline = new ArrayList<>();
    @Getter
    private User currentUser;

    Object noUsersOnlineLock = new Object();
    Object waitChatLock = new Object();

    public ChatManager(User user) {
        currentUser = user;
        initUsersOnline();
    }

    public User getInterlocutor() {
        return currentUser.getCurrentChat().getUser2();
    }

    private synchronized void initUsersOnline() {
        usersOnline.addAll(users.getUsers());
        usersOnline.remove(currentUser);
    }

    public void startChat() {
        synchronized (noUsersOnlineLock) {
            while (usersOnline.isEmpty()) {
                try {
                    noUsersOnlineLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            User interlocutor = usersOnline.remove(0);
            Chat newChat = new Chat(++id ,currentUser, usersOnline.remove(0));
            interlocutor.setCurrentChat(newChat);
            currentUser.setCurrentChat(newChat);
            CHATS_ONLINE.add(newChat);
            synchronized (waitChatLock) {
                waitChatLock.notifyAll();  // Ensure notify() is called on the right object
            }
        }
    }
    public void waitForChat() {
        synchronized (waitChatLock) {
            while (currentUser.getCurrentChat() == null) {
                try {
                    waitChatLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("дождались чата ура");
        }

    }
    public synchronized void endChat() {
        if (currentUser.getCurrentChat() != null) {
            usersOnline.add(currentUser.getCurrentChat().getUser2());
            CHATS_ONLINE.remove(currentUser.getCurrentChat());
            currentUser.setCurrentChat(null);
            synchronized (noUsersOnlineLock) {
                noUsersOnlineLock.notifyAll();  // Ensure notify() is called on the right object
            }
        }
    }
}
