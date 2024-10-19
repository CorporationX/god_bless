package school.faang.mattersoftheheart;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Slf4j
public class ChatManager {
    private final UserList userList;
    private final List<Chat> chats = new ArrayList<>();

    public synchronized void startChat(User user) {
        if (user.isLookingForChat()) {
            Optional<User> companionOptional = userList.findCompanionForUser(user);
            if (companionOptional.isPresent()) {
                log.info("{} and {} start chatting", user.getName(), companionOptional.get().getName());
                Chat chat = new Chat(user, companionOptional.get());
                user.setLookingForChat(false);
                companionOptional.get().setLookingForChat(false);
                chats.add(chat);
            } else {
                waitForChat(user);
            }
        }
    }

    public synchronized void endChat(User user) {
        Optional<Chat> chatOptional = chats.stream().filter(chat -> chat.user1().equals(user)).findFirst();
        if (chatOptional.isPresent()) {
            chats.remove(chatOptional.get());
            chatOptional.get().user1().setLookingForChat(true);
            chatOptional.get().user2().setLookingForChat(true);
            log.info("{} and {} end chatting", user.getName(), chatOptional.get().user2().getName());
            notifyAll();
        }
    }

    private synchronized void waitForChat(User user) {
        while (userList.findCompanionForUser(user).isEmpty()) {
            try {
                log.info("{} waiting for companion", user.getName());
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        startChat(user);
    }
}
