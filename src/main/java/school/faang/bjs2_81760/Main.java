package school.faang.bjs2_81760;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;
    private static UserList userList = new UserList();
    private static ChatManager chatManager = new ChatManager(userList);

    public static void main(String[] args) {
        userList.addUser(new User("Anna"));
        userList.addUser(new User("Ivan"));
        userList.addUser(new User("Inna"));
        userList.addUser(new User("Oleg"));
        userList.addUser(new User("Petr"));
        userList.addUser(new User("Sakura"));
        userList.addUser(new User("Tanaka"));
        userList.addUser(new User("Akira"));
        userList.addUser(new User("Hinata"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        userList.getUsers().forEach(user -> executor.execute(() -> {
            try {
                chatManager.startChat(user);
                Thread.sleep(5000);
                chatManager.endChat(user);
            } catch (InterruptedException | RuntimeException e) {
                log.error("Поток был прерван", e);
                Thread.currentThread().interrupt();
            }
        }));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван");
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }

        log.info("Все задачи завершены");
    }
}
