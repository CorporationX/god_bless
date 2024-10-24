package school.faangSprint3.t11;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatManager {
    private final UserList userList;
    private final Map<User, Chat> activeChats = Collections.synchronizedMap(new HashMap<>());
    private final Object lock = new Object();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public Chat startChat(User initiator) throws InterruptedException {
        synchronized (lock) {
            initiator.setOnline(true);
            initiator.setLookingForChat(true);

            while (true) {
                List<User> availableUsers = userList.getOnlineUsers().stream()
                        .filter(u -> u != initiator && !activeChats.containsKey(u))
                        .toList();

                if (!availableUsers.isEmpty()) {
                    User partner = availableUsers.get(0);
                    Chat chat = new Chat(initiator, partner);
                    activeChats.put(initiator, chat);
                    activeChats.put(partner, chat);
                    partner.setLookingForChat(false);
                    initiator.setLookingForChat(false);
                    lock.notifyAll();
                    return chat;
                }

                lock.wait();
            }
        }
    }

    public Chat waitForChat(User user) throws InterruptedException {
        synchronized (lock) {
            while (!activeChats.containsKey(user)) {
                lock.wait();
            }
            return activeChats.get(user);
        }
    }

    public void endChat(User user) {
        synchronized (lock) {
            Chat chat = activeChats.get(user);
            if (chat != null) {
                User otherUser = chat.getUser1() == user ? chat.getUser2() : chat.getUser1();
                activeChats.remove(user);
                activeChats.remove(otherUser);
                user.setLookingForChat(false);
                otherUser.setLookingForChat(false);
                lock.notifyAll();
            }
        }
    }
}