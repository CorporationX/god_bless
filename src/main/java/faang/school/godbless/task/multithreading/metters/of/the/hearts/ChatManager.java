package faang.school.godbless.task.multithreading.metters.of.the.hearts;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ChatManager {
    private final UserList userList;

    public boolean startChat(User user) {
        synchronized (this) {
            Optional<Chat> userChat = user.getChat();
            if (userChat.isPresent() && userChat.get().isAlive()) {
                log.info("{} присоединяется к чату с: {}", user, userChat.get().getOpponent(user));
                return true;
            } else {
                return searchUserForChat(user);
            }
        }
    }

    private boolean searchUserForChat(User user) {
        log.info("{} начал поиск пользователя для чата", user);
        Optional<User> userB = findChatUser(user);
        if (userB.isPresent()) {
            assignChat(user, userB.get());
            return true;
        } else {
            return false;
        }
    }

    private Optional<User> findChatUser(User user) {
        return userList.getOnlineUsers()
                .stream()
                .filter(onlineUser -> !onlineUser.equals(user))
                .filter(User::isWantChat)
                .findFirst();
    }

    private void assignChat(User userA, User userB) {
        log.info("{} создает новый чат с {}", userA, userB);
        Chat chat = new Chat(userA, userB);
        userA.assignChat(chat);
        userB.assignChat(chat);
        notifyIfSleep(userB);
    }

    private void notifyIfSleep(User user) {
        if (user.isAsleep()) {
            log.info("Оповещение для {}, для выхода из режима ожидания", user);
            user.notifyUser();
        }
    }
}
