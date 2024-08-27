package faang.school.godbless.Matters_of_the_heart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ChatManager {
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public void startChat(User initiator) {
        synchronized (userList) {
            List<User> onlineUsers = userList.getOnlineUsers();
            onlineUsers.remove(initiator);

            if (!onlineUsers.isEmpty()) {
                User participant = onlineUsers.get(0);
                Chat chat = new Chat(initiator, participant);
                activeChats.add(chat);
                chat.start();
                return;
            }

            try {
                log.info("На данный момент, нет доступных пользователей. {} Ожидает.", initiator.getName());
                userList.wait();
            } catch (InterruptedException e) {
                log.error("Поток прерван", e);
            }
        }
    }

    public Chat getActiveChat(User user) {
        synchronized (userList) {
            return activeChats.stream()
                    .filter(chat -> chat.getInitiator().equals(user) || chat.getParticipant().equals(user))
                    .findFirst()
                    .orElse(null);
        }
    }

    public void waitForChat(User user) {
        synchronized (userList) {
            while (activeChats.stream().noneMatch(chat -> chat.getInitiator().equals(user) ||
                    chat.getParticipant().equals(user))) {
                try {
                    userList.wait();
                } catch (InterruptedException exception) {
                    log.error("Поток прерван", exception);
                }
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            activeChats.remove(chat);
            chat.end();
            userList.notifyAll();
        }
    }
}
