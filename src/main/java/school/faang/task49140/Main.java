package school.faang.task49140;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int TIME_TO_AWAIT = 10;

    private static void handInterrupt(HandlerInterrupted handler) {
        try {
            handler.test();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message in method {} ", e.getStackTrace()[2].getMethodName(), e);
        }
    }

    private static UserList initialize() {
        return new UserList(new ArrayList<>(List.of(
                new User("Алексей", true, false),
                new User("Сергей", true, true),
                new User("Кирилл", false, false),
                new User("Светлана", false, false),
                new User("Анастасия", false, false),
                new User("Дмитрий", true, false),
                new User("Данил", true, true),
                new User("Сёмен", true, true),
                new User("Мария", true, true),
                new User("Анна", true, true)
        )));
    }

    public static void main(String[] args) throws InterruptedException {
        UserList users = initialize();
        ChatManager manager = new ChatManager(users);
        List<User> usersList = users.getUsers();

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, usersList.size()).boxed()
                .forEach(i -> {
                    if (usersList.size() / 2 > i) {
                        executorService.execute(() ->
                                handInterrupt(() -> manager.waitChat(usersList.get(i))));
                    }
                    executorService.execute(() ->
                            handInterrupt(() -> manager.startChat(usersList.get(i))));
                });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIME_TO_AWAIT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message: ", e);
        } finally {
            if (!executorService.isShutdown()) {
                executorService.shutdownNow();
            }
        }
    }
}