package school.faang.bjs2_81760;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class ChatManager {
    private final UserList userList;

    public synchronized void startChat(User currentUser) {
        if (!currentUser.isLookingForChat()) {
            log.info("У пользователя {} уже открыт чат", currentUser.getName());
            return;
        }

        log.info("Пользователь {} открывает чат", currentUser.getName());
        Chat chat = null;

        while (chat == null) {
            List<User> onlineUsers = userList.getOnlineUsers(currentUser);

            if (!onlineUsers.isEmpty()) {

                User foundUser = onlineUsers.get(0);
                log.info("Для {} найден собеседник - {} ", currentUser.getName(), foundUser.getName());

                chat = new Chat(currentUser, foundUser);
                currentUser.switchChatStatus(chat);
                foundUser.switchChatStatus(chat);
                return;
            }

            log.info("Нет доступных для общения пользователей. {} ожидает", currentUser.getName());
            waitForChat();
        }
    }

    private synchronized void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public synchronized void endChat(User user) {
        if (user != null && user.getChat() != null) {
            Chat chat = user.getChat();
            User userOne = chat.userOne();
            User userTwo = chat.userTwo();
            userOne.switchChatStatus();
            userTwo.switchChatStatus();
            log.info("Пользователи {} и {} завершили общение", userOne.getName(), userTwo.getName());
            notifyAll();
        }
    }
}
