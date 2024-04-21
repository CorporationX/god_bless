package faang.school.godbless.mattersoftheheart;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Slf4j
public class ChatManager {
    private static final List<Chat> chats = new ArrayList<>();
    private UserList userList;

    public void startChat(User user) {
        user.setWantToChat(true);
        synchronized (chats) {
            log.info("User {} wants to join the chat", user.getName());
            Optional<User> optionalUser = userList.getWantedToChatUsers().stream().findAny();
            if (optionalUser.isPresent()) {
                Chat chat = new Chat();
                chat.addUserToChat(user);
                chat.addUserToChat(optionalUser.get());
                user.setWantToChat(false);
                optionalUser.get().setWantToChat(false);
                chats.add(chat);
                log.info("{} and {} in chat now", user.getName(), optionalUser.get().getName());
            } else {
                waitForChat();
            }
            log.info("{} joined the chat", user.getName());
        }
    }

    public void waitForChat() {
        try {
            chats.wait();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void endChat(User user) {
        synchronized (chats) {
            Optional<Chat> userChat = chats.stream()
                    .filter(chat -> chat.getChat().stream().anyMatch(user::equals))
                    .findFirst();
            if (userChat.isPresent()) {
                userChat.get().removeUserFromChat(user);
                log.info("{} leave chat", user.getName());
                if (userChat.get().getChat().isEmpty()) {
                    log.info("Chat removed");
                    chats.remove(userChat.get());
                }
            }
        }
    }

    public void printCurrentChats() {
        log.info("Current chats");
        chats.forEach(chat -> System.out.println(chat.getChat()));
    }
}
