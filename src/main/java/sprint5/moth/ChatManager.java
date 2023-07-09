package sprint5.moth;

import lombok.Data;

import java.util.Optional;

@Data
public class ChatManager {
    private final Chat chat = new Chat();
    private final UserList userList;
    private final Object waitingLock = new Object();

    public synchronized void startChat(User user) {
        chatPreparation(user);
        Optional<User> foundUser = getOnlineUser();

        if (foundUser.isPresent()) {
            chat.startChat(user, foundUser.get());
        } else {
            waitUsers();
            foundUser = getOnlineUser();
            chat.startChat(user, foundUser.get());
        }
        chat.chatIsNotReady();
        chat.endChat(user, foundUser.get());
    }

    public void waitForChat(User user) {
        synchronized (chat) {
            user.online();
            System.out.printf("%s looking for an active chat room\n", user.getName());
            if (chat.isReady() && !chat.isChatting()) {
                System.out.printf("%s found chat\n", user.getName());
                synchronized (waitingLock) {
                    waitingLock.notify();
                }
            } else {
                System.out.printf("%s waiting chat\n", user.getName());
                waitChat();
            }
        }
    }

    private void chatPreparation(User user) {
        user.online();
        chat.chatIsReady();
        synchronized (waitingLock) {
            waitingLock.notify();
        }
        System.out.printf("%s ready to start chatting\n", user.getName());
    }

    private Optional<User> getOnlineUser() {
        return userList.getOnlineUsers().stream()
                .findFirst();
    }

    private void waitUsers() {
        try {
            synchronized (waitingLock) {
                waitingLock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void waitChat() {
        try {
            chat.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
