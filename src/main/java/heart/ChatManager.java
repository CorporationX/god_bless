package heart;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class ChatManager {
    private static final long TIME_OUT = 30L * 1000;
    private final UserList users;
    private final List<User> waitingForChatUsers = new ArrayList<>();
    private final Map<Chat, List<User>> chatUserList = new HashMap<>();
    @Getter
    private final List<Chat> archivedChats = new ArrayList<>();

    public synchronized void startChat(@NonNull User user) {
        if (!users.getOnlineUsers().contains(user)) {
            throw new IllegalArgumentException("User not online");
        }
        if (user.getCurrentChat() != null) {
            throw new IllegalArgumentException("User already in the chat");
        }
        if (waitingForChatUsers.isEmpty()) {
            waitingForChatUsers.add(user);
            this.notifyAll();
            waitForChat(user);
        } else {
            int opponentIdx = ThreadLocalRandom.current().nextInt(waitingForChatUsers.size());
            var opponent = waitingForChatUsers.get(opponentIdx);
            Chat chat = new Chat();
            user.setCurrentChat(chat);
            opponent.setCurrentChat(chat);
            this.notifyAll();
            chatUserList.put(chat, new ArrayList<>(List.of(user, opponent)));
            waitingForChatUsers.remove(opponentIdx);
            log.info(String.format("Chat between %s and %s started", user.getName(), opponent.getName()));
        }
    }

    public synchronized void endChat(@NonNull Chat chat, @NonNull User user) {
        var chatUsers = chatUserList.get(chat);
        user.setCurrentChat(null);
        chatUsers.remove(user);
        log.info(user.getName() + " leave chat");
        if (chatUserList.get(chat).isEmpty()) {
            chatUserList.remove(chat);
            archivedChats.add(chat);
            log.info("Chat ended");
        }
    }

    private synchronized void waitForChat(@NonNull User user) {
        log.info(user.getName() + " waiting for opponent");
        while (user.getCurrentChat() == null) {
            try {
                wait(TIME_OUT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
