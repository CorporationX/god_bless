package faang.school.godbless.synchronization.task_7.util;

import faang.school.godbless.synchronization.task_7.model.Chat;
import faang.school.godbless.synchronization.task_7.model.User;
import faang.school.godbless.synchronization.task_7.model.UserList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@AllArgsConstructor
public class ChatManager {
    private final UserList userList;
    private final Map<Integer, Chat> activeChats = new ConcurrentHashMap<>();

    public synchronized void startChat(User user) {
        List<User> onlineUsers = userList.getOnlineUsers();
        List<User> readyToChatUsers = onlineUsers.stream()
                .filter(partner -> !user.equals(partner) && partner.isWaitingForChat())
                .toList();
        if (readyToChatUsers.isEmpty()) {
            System.out.println("пользователь " + user.getName() + " ждет очереди для общения");
            try {
                this.wait(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        } else {
            Optional<User> partner = readyToChatUsers.stream()
                    .filter(usr -> !user.equals(usr))
                    .findAny();
            partner.ifPresent(companion -> {
                Chat chat = new Chat(user, companion);
                user.startChatting(chat.getChatId());
                companion.startChatting(chat.getChatId());
                activeChats.put(chat.getChatId(), chat);
                System.out.println(user.getName() + " и " + companion.getName() + " начали общаться в чате " + chat.getChatId());
            });
            this.notifyAll();
        }
    }

    public synchronized void sendMessageInChat(User user) {
        findCompanion(user).ifPresent(partner ->
                System.out.println(user.getName() + " отправил сообщение " + partner.getName()));
    }

    public synchronized void endChat(User user) {
        Chat leavingChat = activeChats.get(user.getChatId());
        if (leavingChat != null) {
            Optional<User> companion = leavingChat.getUsersInChat().stream().filter(usr -> !usr.equals(user)).findFirst();
            leavingChat.deactivateChat();
            companion.ifPresent(partner -> startChat(partner));
        }
    }

    private Optional<User> findCompanion(User user) {
        Optional<User> optionalUser = Optional.empty();
        Chat commonChat = activeChats.get(user.getChatId());
        if (commonChat != null) {
            optionalUser = commonChat.getUsersInChat().stream().filter(usr -> !usr.equals(user)).findFirst();
        }
        return optionalUser;
    }
}