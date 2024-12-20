package school.faang.task_49142;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Users users = new Users();
    private static final ChatManager manager = new ChatManager(users);
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> users.addUser(new User("User-" + i)));

        users.removeUser(new User("User-10"));

        users.forEach(user -> {
            if (user.isAvailableForChat()) {
                executor.execute(() -> manager.startChat(user));
            }
        });

        users.forEach(manager::endChat);

        executor.shutdown();

        try {
            if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Task completed successfully.");
            } else {
                log.info("Остался ожидающий юзер");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
