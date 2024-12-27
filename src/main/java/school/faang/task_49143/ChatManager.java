package school.faang.task_49143;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ChatManager {
    private static final int SIMULATION_TIME = 3000;

    private final UserList userList;
    private final Lock lock;
    private final Condition availablePartner;
    private static final Logger logger = Logger.getLogger(ChatManager.class.getName());
    private final Set<Chat> activeChats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.lock = new ReentrantLock();
        this.availablePartner = lock.newCondition();
        this.activeChats = new HashSet<>();
    }

    public void startChat(User user) {
        if (!user.isLookingForChat()) {
            logger.info(user.getName() + " не ищет чат.");
            return;
        }

        lock.lock();
        try {
            List<User> availableUsers = findAvailableChatPartners(user);

            while (availableUsers.isEmpty()) {
                logger.info(user.getName() + " ожидает доступного собеседника...");
                availablePartner.await();
                availableUsers = findAvailableChatPartners(user);
            }

            User partner = availableUsers.get(0);
            user.setLookingForChat(false);
            partner.setLookingForChat(false);

            Chat chat = new Chat(user, partner);
            activeChats.add(chat);

            logger.info("Чат начат между " + user.getName() + " и " + partner.getName());
            simulateChat(chat);

        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Поток был прерван для " + user.getName(), e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private void simulateChat(Chat chat) {
        new Thread(() -> {
            try {
                Thread.sleep(SIMULATION_TIME);
                endChat(chat);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Ошибка во время симуляции чата.", e);
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void endChat(Chat chat) {
        lock.lock();
        try {
            logger.info("Чат завершен между " + chat.getUser1().getName() + " и " + chat.getUser2().getName());

            chat.getUser1().setLookingForChat(true);
            chat.getUser2().setLookingForChat(true);

            activeChats.remove(chat);

            availablePartner.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private List<User> findAvailableChatPartners(User user) {
        return userList.getOnlineUsers().stream()
                .filter(u -> u.isLookingForChat() && !u.equals(user))
                .collect(Collectors.toList());
    }
}
