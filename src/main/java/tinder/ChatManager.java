package tinder;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Slf4j
public class ChatManager {
    private final Queue<User> waitingQueue = new LinkedList<>();
    private final Map<User, Chat> activeChats = new HashMap<>();

    public synchronized Chat startChat(User user) throws InterruptedException {
        if (!waitingQueue.isEmpty()) {
            User partner = waitingQueue.poll();
            Chat chat = new Chat(partner, user);
            activeChats.put(partner, chat);
            activeChats.put(user, chat);
            log.info("Chat started: {}", chat);
            notifyAll();
            return chat;
        } else {
            waitingQueue.offer(user);
            while (!activeChats.containsKey(user)) {
                wait();
            }
            return activeChats.get(user);
        }
    }

    public synchronized Chat waitForChat(User user) throws InterruptedException {
        while (!activeChats.containsKey(user)) {
            wait();
        }
        return activeChats.get(user);
    }

    public synchronized void endChat(Chat chat) {
        if (chat != null) {
            activeChats.remove(chat.getUser1());
            activeChats.remove(chat.getUser2());
            log.info("Chat ended: {}", chat);
            notifyAll();
        }
    }
}
