package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    private List<Chat> chatList = new ArrayList<>();

    private UserList userList;

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized void startChat(User user) {
        userList.deleteOfflineUser();

        Optional<User> userChat = userList.getOnlineUsers().stream()
                .filter(x -> !x.equals(user))
                .findAny();
        if (!userChat.isPresent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Chat chat = new Chat(user, userChat.get());
        chatList.add(chat);

    }

    public void waitForChat(User user) {
    }

    public void endChat() {

    }
}
