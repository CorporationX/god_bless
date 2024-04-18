package faang.school.godbless.bjs2_5684;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Setter
public class ChatManager {

    private static final List<Chat> chats = new ArrayList<>();
    private UserList userList;
    private List<User> whoWantsToChat = new ArrayList<>();


    //Вызывается, когда пользователь хочет начать чат.
    // Метод должен найти другого пользователя, который тоже хочет начать чат и создать для них новый чат.
    // Если никого нет, то метод должен ожидать, пока не появится другой пользователь, который хочет начать чат.
    public void startChat(User user) {
        synchronized (chats) {
            log.info("User {} wants to join the chat", user.getName());
            // List<User> onlineUsers = userList.getOnlineUsers().stream().filter(person -> !user.equals(person)).toList();
            // Проверить есть ли другие пользователи, которые хотят начать чат.
            if (whoWantsToChat.isEmpty()) {
                // Если нет, то вызвать wait()
                // Добавить пользователя в список ожидания на чат
                log.info("No one who wants to chat. {} go to queue for chat", user.getName());
                whoWantsToChat.add(user);
                try {
                    chats.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            } else {
                // Если есть ждущие пользователи, то создать чат
                Chat chat = new Chat();
                //добавить пользователя в чат
                chat.addUserToChat(user);
                //Добавить первого пользователя в списке ожидания на чат
                User userWaitToChat = whoWantsToChat.get(0);
                chat.addUserToChat(userWaitToChat);
                whoWantsToChat.remove(userWaitToChat);
                chats.add(chat);
                log.info("{} and {} in chat now", user.getName(), userWaitToChat.getName());
                chats.notify();
            }
            log.info("{} joined the chat", user.getName());
        }
    }

//    public void waitForChat(User user) {
//        // Проверить есть ли чат в котором участвует пользователь
//        if (chats.stream()
//                .flatMap(chat -> chat.getChatUsers().stream())
//                .noneMatch(user::equals)) {
//            // Если чат не найден, вызовите метод wait() и ждите пока чат не будет создан.
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                log.error(e.getMessage());
//            }
//        }
//    }

    public void endChat(User user) {
        synchronized (chats) {
            Optional<Chat> userChat = chats.stream()
                    .filter(chat -> chat.getChatUsers().stream().anyMatch(user::equals))
                    .findFirst();
            if (userChat.isPresent()) {
                userChat.get().removeUserFromChat(user);
                log.info("{} leave chat", user.getName());
                if (userChat.get().getChatUsers().isEmpty()) {
                    log.info("Chat removed");
                    chats.remove(userChat.get());
                }
            }

        }
    }

    public void printCurrentChats() {
        log.info("Current chats");
        chats.forEach(chat -> System.out.println(chat.getChatUsers()));
    }
}
