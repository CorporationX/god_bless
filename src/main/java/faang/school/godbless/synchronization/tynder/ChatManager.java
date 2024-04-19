package faang.school.godbless.synchronization.tynder;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class ChatManager {
    private final List<Chat> activeChats = new ArrayList<>();
    private final UserList userList = new UserList();

    public static void userCheck(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can't be null-valued!");
        }
    }

    public synchronized void startChat(User user) {
        userCheck(user);

        var onlineUsers = userList.getOnlineUsers().stream()
                .filter(onlineUser -> !onlineUser.equals(user))
                .toList();

        var usersWaitingForChat = onlineUsers.stream()
                .filter(User::isWaitingForChat)
                .toList();

        if (usersWaitingForChat.size() == 0) {
            user.waitForChat();

            log.info("User " + user.getName() + " is waiting for chat.");

            try {
                this.wait(30000);
            } catch (InterruptedException e) {
                log.warn("Waiting was interrupted");
            }

            return;
        }


        var userToChatWith = usersWaitingForChat.stream()
                .findAny();

        userToChatWith.ifPresent(partner -> newChat(user, partner));
    }

    private synchronized void newChat(User user, User partner) {
        if (user == null || partner == null) {
            throw new IllegalArgumentException("Users can't be null-valued");
        }

        var newChat = new Chat();

        newChat.addUserInChat(user);
        newChat.addUserInChat(partner);

        user.startChatting();
        partner.startChatting();

        activeChats.add(newChat);

        log.info("New chat have been created between " + user.getName() + " and " + partner.getName());

        this.notifyAll();
    }

    public synchronized void endChat(User user) {
        userCheck(user);

        if (!user.isChatting()) {
            return;
        }

        var userChats = activeChats.stream()
                .filter(chat -> chat.hasUser(user))
                .toList();

        var chatPartners = userChats.stream()
                .flatMap(chat -> chat.getUsersInChat().stream())
                .distinct()
                .filter(currentUser -> !currentUser.equals(user))
                .toList();

        activeChats.removeAll(userChats);

        user.stopChatting();

        log.info("User " + user.getName() + " left all his(her) chats");

        chatPartners.forEach(partner -> {
            partner.stopChatting();

            startChat(partner);
        });
    }

    public synchronized void sendMessageViaChat(User user) {
        userCheck(user);

        var userChats = activeChats.stream()
                .filter(chat -> chat.hasUser(user))
                .toList();

        var chatPartners = userChats.stream()
                .flatMap(chat -> chat.getUsersInChat().stream())
                .distinct()
                .filter(currentUser -> !currentUser.equals(user))
                .toList();

        chatPartners.forEach(partner -> log.info("User " + user.getName() + " sent message to " + partner.getName()));
    }
}
