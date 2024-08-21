package faang.school.godbless.task.multithreading.metters.of.the.hearts;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private final static int NUMBER_OF_USERS = 57;
    private final static int THREAD_POOL_LIMIT = NUMBER_OF_USERS;

    private final static ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
    private final static UserList userList = new UserList();
    private final static ChatManager chatManager = new ChatManager(userList);
    private final static Random random = new Random();

    public static void main(String[] args) {
        log.info("Запущено {} потоков, для {} пользователей:", THREAD_POOL_LIMIT, NUMBER_OF_USERS);
        var users = getUsers();
        users.forEach(user -> executor.execute(() -> {
            userRandomMove(user);
            notifyAndOffline(user);
        }));
        executor.shutdown();
    }

    private static void userRandomMove(User user) {
        IntStream
                .range(0, random.nextInt(3))
                .forEach(i -> {
                    if (random.nextBoolean()) {
                        user.online();
                        threadSleep(random.nextInt(5000));
                    }
                    if (random.nextBoolean()) {
                        user.findChat();
                        threadSleep(random.nextInt(15000));
                        if (random.nextBoolean()) {
                            user.closeChat();
                        }
                    }
                    if (random.nextBoolean()) {
                        notifyAndOffline(user);
                    }
                });
    }

    private static void notifyAndOffline(User user) {
        if (user.isOnline()) {
            synchronized (user) {
                user.notify();
            }
            user.offline();
        }
    }

    private static List<User> getUsers() {
        return IntStream.rangeClosed(1, NUMBER_OF_USERS)
                .mapToObj(i -> new User(i, "User " + i, userList, chatManager))
                .toList();
    }

    private static void threadSleep(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            log.error("Interrupt: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
