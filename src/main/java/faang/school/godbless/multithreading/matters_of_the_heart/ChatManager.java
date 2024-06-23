package faang.school.godbless.multithreading.matters_of_the_heart;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    private UserList userList;

    private List<Chat> chats = new ArrayList<>();

    public void startChat(User user) {

        synchronized (this) {
            Optional<User> activeUsers = userList.getOnlineUsers().stream()
                    .filter(u -> u.hashCode() != user.hashCode() && user.isCommunication())
                    .findFirst();


            if (activeUsers.isPresent()) {
                user.setCommunication(false);
                activeUsers.get().setCommunication(false);
                Chat chat = new Chat(user, activeUsers.get(), true);
                chats.add(chat);

            } else {
                waitForChat();
            }
        }

    }

    public void waitForChat() {
    }

    public void endChat() {
    }
}
