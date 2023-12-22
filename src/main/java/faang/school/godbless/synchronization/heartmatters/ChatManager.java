package faang.school.godbless.synchronization.heartmatters;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ChatManager {

    @Getter
    private final List<Chat> activeChats;
    private final UserList userList;
    private final Object mainLock;
    private final Object chattingLock;

    public ChatManager(UserList userList) {
        this.userList = userList;
        mainLock = new Object();
        activeChats = new ArrayList<>();
        chattingLock = new Object();
    }

    public Chat startChat(User wantsToChatUser) throws InterruptedException {
        synchronized (mainLock) {
            Optional<User> optionalUser;
            while ((optionalUser = userList.getAvailableUser()).isEmpty()
                    || optionalUser.get().equals(wantsToChatUser)) {
                System.out.println(wantsToChatUser.getName() + " wait");
                mainLock.wait();
            }
            User availableUser = optionalUser.get();

            Chat chat = new Chat(wantsToChatUser, availableUser);
            activeChats.add(chat);
            return chat;
        }
    }

    public void waitForChat(Chat chat) throws InterruptedException {
        synchronized (chattingLock) {
            while (!isChatActive(chat)) {
                System.out.println("user is wait for chat" + chat);
                mainLock.wait();
            }
            startChatting(chat);
        }
    }

    private void startChatting(Chat chat) throws InterruptedException {
        System.out.printf("%s & %s start chatting\n",
                chat.getFirstUser().getName(),
                chat.getSecondUser().getName());
        chattingLock.wait(new Random().nextInt(5000, 10000));
    }

    public void endChat(Chat chat) throws InterruptedException {
        synchronized (mainLock) {
            User firstUser = chat.getFirstUser();
            User secondUser = chat.getSecondUser();
            System.out.printf("%s & %s finished\n", firstUser.getName(), secondUser.getName());
            firstUser.setAvailable(true);
            secondUser.setAvailable(true);
            activeChats.remove(chat);
            mainLock.notifyAll();
        }
    }

    private boolean isChatActive(Chat chat) {
        return activeChats.contains(chat);
    }

}
