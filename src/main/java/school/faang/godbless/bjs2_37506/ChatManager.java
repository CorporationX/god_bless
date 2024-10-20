package school.faang.godbless.bjs2_37506;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ChatManager {
    private final UserList userList;
    private final Set<Chat> chats = new HashSet<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized Chat startChat() throws InterruptedException {
        Chat chat = waitForChat();
        chats.add(chat);
        log.info("Created new chat between {} and {}", chat.getUser1(), chat.getUser2());
        return chat;
    }

    public synchronized void addAvailableUser(User user) {
        user.setLookingForChat(true);
        userList.addUser(user);
        log.info("New available user: {}", user);
        notifyAll();
    }

    private Chat waitForChat() throws InterruptedException {
        List<User> availableUsers = userList.getOnlineUsers().stream().filter(User::isLookingForChat)
                .limit(2).toList();
        while (availableUsers.size() < 2) {
            log.info("Thread {} is waiting for more available users", Thread.currentThread().getName());
            wait();
            availableUsers = userList.getOnlineUsers().stream().filter(User::isLookingForChat)
                    .limit(2).toList();
        }
        availableUsers.forEach(u -> u.setLookingForChat(false));
        return new Chat(availableUsers.get(0), availableUsers.get(1));
    }

    public synchronized void endChat(Chat chat) {
        userList.removeUser(chat.getUser1());
        userList.removeUser(chat.getUser2());
        chats.remove(chat);
        log.info("Chat with {} and {} is over", chat.getUser1(), chat.getUser2());
    }
}
