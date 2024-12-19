package school.faang.task49140;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ChatManager {

    private final Object lockChat = new Object();
    private final Object userWait = new Object();
    private final UserList users;
    private final List<Chat> chats = new ArrayList<>();

    public synchronized void startChat(User user) throws InterruptedException {
        changeAllStatus(user);

        while (users.getOnlineUser().isEmpty()) {
            lockChat.wait();
        }
        userWait.notifyAll();

        Chat chat = new Chat(user, users.getOnlineUser().stream().findFirst().get());
        chats.add(chat);
    }

    public synchronized void waitChat(User user) throws InterruptedException {
        changeAllStatus(user);

        lockChat.notifyAll();

        List<Chat> chatsActive = chats.stream().filter(Chat::isChatActive).toList();

        while (chatsActive.isEmpty()) {
            userWait.wait();
            chatsActive = chats.stream().filter(Chat::isChatActive).toList();
        }
    }

    private void changeAllStatus(User user) {
        user.changeStatus(Status.ONLINE);
        user.lookingForChat(Status.CHAT);
    }

    public void endChat(Chat chat) {

    }
}
