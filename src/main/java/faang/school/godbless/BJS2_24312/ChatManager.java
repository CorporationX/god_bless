package faang.school.godbless.BJS2_24312;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class ChatManager {
    private UserList users;
    private List<Chat> chats;

    public ChatManager(UserList users) {
        this.users = users;
        this.chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) throws InterruptedException {
        User userToTalk = users.getOnlineAndLookingForChattingUsers(user);
        while (userToTalk == null || chats.contains(user.getChat())) {
            log.info("No users to talk, waiting for it by {}", user);
            waitForChat();
            userToTalk = users.getOnlineAndLookingForChattingUsers(user);
        }

        Chat chat = new Chat(user, userToTalk);
        chats.add(chat);
        user.connectToChat(chat);
        userToTalk.connectToChat(chat);
        log.info("Starting chatting between {}, {}", chat.getFirstUser(), chat.getSecondUser());
    }

    private synchronized void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread got error: {}", e.getMessage());
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        chats.remove(chat);
        chat.getFirstUser().disconnectFromChat();
        chat.getSecondUser().disconnectFromChat();
        notifyAll();
        log.info("Chat is ended, {} and {} are free to talk again", chat.getFirstUser(), chat.getSecondUser());
    }
}
