package school.faang.mattersoftheheart;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final long DELAY = 0;
    private static final long PERIOD = 30;
    public static final long TIMEOUT = PERIOD + 2;
    private static final long WORKING_CHAT_PERIOD = 5;

    public static void main(String[] args) {
        ChatManager chatManager = new ChatManager(registerUsers());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        for (User user : chatManager.getUserList().getOnlineUsers()) {
            executorService.scheduleAtFixedRate(() -> {
                chatManager.startChat(user);
                chatting();
                chatManager.endChat(user);
            }, DELAY, PERIOD, TimeUnit.SECONDS);
        }

        closeChat(executorService);
    }

    private static UserList registerUsers() {
        User alex = new User("Alex", true, true);
        User ann = new User("Ann",  true, true);
        User jack = new User("Jack",  true, true);
        User jane = new User("Jane",  true, true);
        User lisa = new User("Lisa",  true, true);
        User bred = new User("Bred",  true, false);
        User kate = new User("Kate",  false, false);
        UserList userList = new UserList();
        userList.addUser(alex);
        userList.addUser(ann);
        userList.addUser(jack);
        userList.addUser(jane);
        userList.addUser(lisa);
        userList.addUser(bred);
        userList.addUser(kate);
        return userList;
    }

    private static void chatting() {
        try {
            TimeUnit.SECONDS.sleep(PERIOD);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void closeChat(ScheduledExecutorService executorService) {
        try {
            TimeUnit.MINUTES.sleep(WORKING_CHAT_PERIOD);
            log.info("Чат закрывается...");
            executorService.shutdown();
            if (executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Чат закрыт!");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
