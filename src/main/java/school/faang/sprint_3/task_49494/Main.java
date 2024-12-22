package school.faang.sprint_3.task_49494;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int CHATS_COUNT = 2;
    private static final int THREADS_SIZE = 3;
    private static final int TIMEOUT = 1;
    private static ChatManager manager;

    public static void main(String[] args) {

        manager = new ChatManager();
        for (int i = 1; i <= CHATS_COUNT; i++) {
            manager.addChat(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        List<Runnable> runnables = getRunnables();
        for (Runnable runnable : runnables) {
            executor.submit(runnable);
        }
        executor.submit(() -> manager.endChat(manager.getChatFromId(1)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                log.error("Поток принудительно завершен из-за превышения времени ожидания выполнения задачи");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван во время ожидания завершения задачи");
        }
        System.out.println("Все пользователи распределены");
    }

    private static List<Runnable> getRunnables() {
        UserList users = new UserList(List.of(
                new User("Alex"),
                new User("Bob"),
                new User("Tom"),
                new User("Sam"),
                new User("Ron"),
                new User("John"),
                new User("Tina", false, false)
        ));

        return users.getOnlineUser().stream()
                .map(user -> (Runnable) () -> manager.startChat(user))
                .toList();
    }
}
