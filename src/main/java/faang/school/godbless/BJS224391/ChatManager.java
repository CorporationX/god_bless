package faang.school.godbless.BJS224391;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ChatManager {
    private UserList users;
    private Map<Chat, List<User>> chatUsers;

    public ChatManager(UserList users) {
        this.users = users;
        this.chatUsers = new HashMap<>();
    }

    public synchronized void startChat(User user) throws InterruptedException {
        if (!user.isChatting()){
            User userToTalk = users.getOnlineUser(user);
            while (userToTalk == null) {
                log.info("No users to talk, waiting for it by {}", user.getName());
                waitForChat();
                userToTalk = users.getOnlineUser(user);
            }
            Chat chat = new Chat();
            user.connectToChat(chat);
            userToTalk.connectToChat(chat);
            chatUsers.put(chat, new ArrayList<>(List.of(user, userToTalk)));
            log.info("Starting chatting between {}, {}", chatUsers.get(chat).get(0).getName(), chatUsers.get(chat).get(1).getName());
        }
    }

    public synchronized void waitForChat() throws InterruptedException {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        if (user.isChatting()){
            Chat chat = user.getChat();
            for (User chatUser : chatUsers.get(chat)) {
                chatUser.disconnectFromChat();
            }
            log.info("Chat is ended, {} and {} are free to talk again", chatUsers.get(chat).get(0).getName(), chatUsers.get(chat).get(1).getName());
            chatUsers.remove(chat);
            notifyAll();
        }
    }
}
